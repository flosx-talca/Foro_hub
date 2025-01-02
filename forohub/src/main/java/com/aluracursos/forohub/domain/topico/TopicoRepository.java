package com.aluracursos.forohub.domain.topico;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
//    boolean findByTitulo(@NotBlank String titulo);
//
//    boolean findByMensaje(@NotBlank String mensaje);

    boolean existsByMensajeAndTitulo(@NotBlank String mensaje, @NotBlank String titulo);
    //UserDetails findByLogin(String username);
}
