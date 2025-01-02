package com.aluracursos.forohub.controller;

import com.aluracursos.forohub.domain.topico.DevolverTopicoDTO;
import com.aluracursos.forohub.domain.topico.RegistrarTopicoDTO;
import com.aluracursos.forohub.domain.topico.Topico;
import com.aluracursos.forohub.domain.topico.TopicoService;
import com.aluracursos.forohub.domain.usuario.Usuario;
import com.aluracursos.forohub.domain.usuario.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;


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
        public ResponseEntity<DevolverTopicoDTO>  registraTopico(@RequestBody @Valid RegistrarTopicoDTO registrarTopicoDTO, UriComponentsBuilder uriComponentsBuilder ){
            return topicoService.procesar(registrarTopicoDTO);


//            System.out.println(usuario.getClave());
//



        }

    @GetMapping("/{id}")
    public ResponseEntity<DevolverTopicoDTO> retonarDatosTopico(@PathVariable Long id){ // Se modifica declaracion del metodo agregano ResponEntity que es para devolver codigo se operacion validas en este caso 204
//        Topico medico = medicoRepository.getReferenceById(id);
//        var datosMedico = new DatosRespuestaMedico(medico.getId(),medico.getNombre(), medico.getEmail(), medico.getTelefono(), medico.getEspecialidad().toString(),
//                new DatosDireccion(medico.getDireccion().getCalle(),medico.getDireccion().getNumero(),medico.getDireccion().getCiudad(), medico.getDireccion().getComplemento(),
//                        medico.getDireccion().getDistrito()));

        return topicoService.topicoPorId(id);
        //return ResponseEntity.ok(datosMedico);
    }






}
