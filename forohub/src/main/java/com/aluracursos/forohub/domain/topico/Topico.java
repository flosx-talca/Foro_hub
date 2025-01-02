package com.aluracursos.forohub.domain.topico;

import com.aluracursos.forohub.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;


@Entity(name = "Topico")
@Table(name = "topicos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(of="id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private String nombreCurso;
    private LocalDateTime fechaCreacion;

    @ManyToOne
    //@JoinColumn(name="usuario_id")
    @JoinColumn(name="usuario_id")
    private Usuario usuario;

    public Topico(RegistrarTopicoDTO datos, Usuario usuario, LocalDateTime fecha) {
        this.titulo = datos.titulo();
        this.mensaje = datos.mensaje();
        this.fechaCreacion = fecha;
        this.nombreCurso = datos.nombreCurso();
        this.usuario = usuario;

    }
}
