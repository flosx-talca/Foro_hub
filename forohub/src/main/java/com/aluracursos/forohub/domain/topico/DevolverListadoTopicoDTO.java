package com.aluracursos.forohub.domain.topico;

import java.time.LocalDateTime;

public record DevolverListadoTopicoDTO(
        String titulo,
        String mensaje,
        String nombreCurso,
        LocalDateTime fechaCreacion,
        String email
) {
}
