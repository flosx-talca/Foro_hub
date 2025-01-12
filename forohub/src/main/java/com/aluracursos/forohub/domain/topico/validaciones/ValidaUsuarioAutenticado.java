package com.aluracursos.forohub.domain.topico.validaciones;

import com.aluracursos.forohub.infraestructura.security.UsuarioUtil;
import org.springframework.stereotype.Component;


@Component
public class ValidaUsuarioAutenticado {
    private final UsuarioUtil usuarioUtil;

    public ValidaUsuarioAutenticado(UsuarioUtil usuarioUtil) {
        this.usuarioUtil = usuarioUtil;
    }

    public void validar(String titulo, String mensaje, Long id){
        Long idUsuario = usuarioUtil.obtenerIdUsuarioAutenticado();
        System.out.println("AAAAAAAAAAAAAAAAAAAA: " + idUsuario);

    }
    //TEST

}


