package com.aluracursos.forohub.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


public record ActualizarTopicoDTO(
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotNull
        String nombreCurso

) {


}
