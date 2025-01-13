package com.aluracursos.forohub.domain.topico.validaciones;

import com.aluracursos.forohub.infraestructura.errores.ValidacionException;
import com.aluracursos.forohub.infraestructura.security.UsuarioUtil;
import org.springframework.stereotype.Component;


@Component
public class ValidaUsuarioAutenticado implements ValidadorTopico {
    private final UsuarioUtil usuarioUtil;

    public ValidaUsuarioAutenticado(UsuarioUtil usuarioUtil) {
        this.usuarioUtil = usuarioUtil;
    }

    public void validar(String titulo, String mensaje, Long id){
        Long idUsuario = usuarioUtil.obtenerIdUsuarioAutenticado();
        if (!idUsuario.equals(id)) {
            throw new ValidacionException("El usuario del body no corresponde al usuario logeado "+ "IDLOGEADO: "+ idUsuario+" IDBODY: "+id);
        }

    }

}


