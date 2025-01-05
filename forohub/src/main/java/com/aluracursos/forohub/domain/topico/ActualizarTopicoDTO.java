package com.aluracursos.forohub.domain.topico;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ActualizarTopicoDTO(
        /*@NotNull
        @Positive
        @Min(1)

        Long idUsuario,
        */

        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotNull
        String nombreCurso


) {


}
