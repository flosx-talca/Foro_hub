package com.aluracursos.forohub.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DevolverTopicoDTO(


        Long id,

        String titulo,

        String mensaje,

        String nombreCurso,

        LocalDateTime fechaCreacion,

        Long idUsuario




) {



}
