package com.aluracursos.forohub.infra;

import com.aluracursos.forohub.domain.ValidacionException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratarErrores {
    @ExceptionHandler(ValidacionException.class)
    public ResponseEntity tratarErrorValidacion(ValidacionException e){
        // getFieldErrors es un metodo mas especifico que getAllErrors
        //var errores = e.getFieldErrors().stream().map(DatosErrorValidacion::new).toList();
        return ResponseEntity.badRequest().body(e.getMessage());
    }

}
