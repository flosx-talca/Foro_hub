package com.aluracursos.forohub.domain.topico;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
//    boolean findByTitulo(@NotBlank String titulo);
//
//    boolean findByMensaje(@NotBlank String mensaje);

    boolean existsByMensajeOrTitulo(@NotBlank String mensaje, @NotBlank String titulo);

//    @Query("SELECT t.id, t.titulo, t.mensaje, t.nombreCurso, t.fechaCreacion, u.email " +
//            "FROM Topico t LEFT JOIN t.usuario u " +
//            "ORDER BY t.fechaCreacion DESC")

}
