package com.aluracursos.forohub.controller;

import com.aluracursos.forohub.domain.topico.RegistrarTopicoDTO;
import com.aluracursos.forohub.domain.topico.TopicoService;
import com.aluracursos.forohub.domain.usuario.Usuario;
import com.aluracursos.forohub.domain.usuario.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        public void registraTopico(@RequestBody @Valid RegistrarTopicoDTO registrarTopicoDTO ){

            LocalDateTime fechaTopico = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);
              Usuario  usuario = usuarioService.buscarUsuario(1L);

            System.out.println(usuario.getClave());
           if(usuario.getClave().contains("12345678")){
               System.out.println("Si");

           }
           else{
               System.out.println("no");
           }



        }




}
