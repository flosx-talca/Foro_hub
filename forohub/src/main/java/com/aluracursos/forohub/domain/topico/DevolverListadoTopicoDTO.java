package com.aluracursos.forohub.domain.topico;

import com.aluracursos.forohub.domain.usuario.Usuario;

import java.time.LocalDateTime;

public record DevolverListadoTopicoDTO(

        //Long id,

        String titulo,

        String mensaje,

        String nombreCurso,

        LocalDateTime fechaCreacion,

        String email

        //Boolean estado
) {
}
