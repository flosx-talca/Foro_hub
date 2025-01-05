package com.aluracursos.forohub.controller;

import com.aluracursos.forohub.domain.topico.*;

import com.aluracursos.forohub.domain.usuario.UsuarioService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("/topico")

public class TopicoController {

    private final TopicoService topicoService;
    private final UsuarioService usuarioService;

    public TopicoController(TopicoService topicoService, UsuarioService usuarioService) {
        this.topicoService = topicoService;
        this.usuarioService = usuarioService;
    }

    @PostMapping

    public ResponseEntity<DevolverTopicoDTO>  registraTopico(@RequestBody @Valid RegistrarTopicoDTO registrarTopicoDTO ) {

        return topicoService.procesar(registrarTopicoDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DevolverTopicoDTO> retonarDatosTopico(@PathVariable Long id){ // Se modifica declaracion del metodo agregano ResponEntity que es para devolver codigo se operacion validas en este caso 204

        return topicoService.topicoPorId(id);

    }

    //@Pageable default define el tamaño y paginacion
    @GetMapping
    public ResponseEntity <Page<DevolverListadoTopicoDTO>> listadoMedicos(@PageableDefault(size = 10, sort = "fechaCreacion", direction = Sort.Direction.ASC) Pageable pagina){

        return ResponseEntity.ok( topicoService.retornaListadoTopico(pagina));

    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity actualizarTopico(@PathVariable @Valid @NotNull @Positive @Min(1) Long id, @RequestBody ActualizarTopicoDTO actualizarTopicoDTO){
        System.out.println(actualizarTopicoDTO.nombreCurso());
        System.out.println("ID: "+ id);
        return ResponseEntity.ok(topicoService.actualizarTopico(actualizarTopicoDTO, id));


    }







}
