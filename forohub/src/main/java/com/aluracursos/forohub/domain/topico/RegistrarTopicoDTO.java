package com.aluracursos.forohub.domain.topico;

import com.aluracursos.forohub.domain.usuario.Usuario;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.format.annotation.NumberFormat;

import java.time.LocalDateTime;

public record RegistrarTopicoDTO(

        @NotNull
        @Positive
        @Min(1)

        Long idUsuario,
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje,
        @NotNull
        String nombreCurso

) {



}
