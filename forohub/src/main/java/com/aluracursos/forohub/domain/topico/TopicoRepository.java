package com.aluracursos.forohub.domain.topico;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
    boolean existsByMensajeOrTitulo(@NotBlank String mensaje, @NotBlank String titulo);
}
