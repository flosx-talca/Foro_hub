package com.aluracursos.forohub.domain.topico.validaciones;

import com.aluracursos.forohub.domain.topico.RegistrarTopicoDTO;

public interface ValidadorTopico {

    default void validar(RegistrarTopicoDTO datos){

    }

}
