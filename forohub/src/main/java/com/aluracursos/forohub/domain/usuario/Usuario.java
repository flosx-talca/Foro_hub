package com.aluracursos.forohub.domain.usuario;


import com.aluracursos.forohub.domain.topico.Topico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity (name="Usuario")
@Table (name="usuarios")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(of="id")

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String clave;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    List<Topico> topico;


}
