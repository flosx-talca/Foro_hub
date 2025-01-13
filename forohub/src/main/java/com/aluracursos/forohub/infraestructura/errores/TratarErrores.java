package com.aluracursos.forohub.infraestructura.errores;

import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class TratarErrores {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> tratarError404(EntityNotFoundException e){
        return ResponseEntity.status(404).body(e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity tratarError400(MethodArgumentNotValidException e){
        var errores = e.getFieldErrors().stream().map(DatosErrorValidacion::new).toList();
        return ResponseEntity.badRequest().body(errores);
    }

    @ExceptionHandler(ValidacionException.class)
    public ResponseEntity tratarErrorValidacion(ValidacionException e){
         return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<List<ErrorValidacion>> manejarExcepcion(ConstraintViolationException e) {
        List<ErrorValidacion> errores = e.getConstraintViolations().stream()
                .map(violacion -> new ErrorValidacion(violacion.getPropertyPath().toString(), violacion.getMessage()))
                .collect(Collectors.toList());
        return ResponseEntity.badRequest().body(errores);
    }


    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity tratarErrorTipoInvalido(MethodArgumentTypeMismatchException e) {
        String mensaje = "El parámetro '" + e.getName() + "' tiene un tipo inválido. Se esperaba un " + e.getRequiredType().getSimpleName();
        return ResponseEntity.badRequest().body(new DatosErrorValidacion(e.getName(), mensaje));
    }

    private record DatosErrorValidacion(String campo, String error){
        public DatosErrorValidacion(FieldError error){
            this(error.getField(),error.getDefaultMessage());
        }

    }

    private record ErrorValidacion(String campo, String error) {}

}
