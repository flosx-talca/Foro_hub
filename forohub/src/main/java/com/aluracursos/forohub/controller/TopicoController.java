package com.aluracursos.forohub.controller;

import com.aluracursos.forohub.domain.topico.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/topico")
@SecurityRequirement(name="bearer-key")

public class TopicoController {

    private final TopicoService topicoService;

    public TopicoController(TopicoService topicoService) {
        this.topicoService = topicoService;

    }

    @PostMapping
    public ResponseEntity<DevolverTopicoDTO>  registraTopico(@RequestBody @Valid RegistrarTopicoDTO registrarTopicoDTO ) {
        return topicoService.registraTopico(registrarTopicoDTO);

    }

    @GetMapping("/{id}")
    public ResponseEntity<DevolverTopicoDTO> retonarDatosTopico(@PathVariable @Valid Long id){ // Se modifica declaracion del metodo agregano ResponEntity que es para devolver codigo se operacion validas en este caso 204
        return topicoService.topicoPorId(id);

    }

        @GetMapping
    public ResponseEntity <Page<DevolverListadoTopicoDTO>> listadoTopicos(@PageableDefault(size = 10, sort = "fechaCreacion", direction = Sort.Direction.ASC) Pageable pagina){
        return  topicoService.retornaListadoTopico(pagina);

    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity actualizarTopico(@PathVariable @Valid Long id, @RequestBody @Valid ActualizarTopicoDTO actualizarTopicoDTO){
        return topicoService.actualizarTopico(actualizarTopicoDTO, id);

    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable @Valid Long id){ // Se modifica declaracion del metodo agregano ResponEntity que es para devolver codigo se operacion validas en este caso 204
        return topicoService.eliminarTopico(id);

    }

}
