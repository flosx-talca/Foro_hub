package com.aluracursos.forohub.infraestructura.security;

import com.aluracursos.forohub.domain.usuario.Usuario;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class UsuarioUtil {

    public Long obtenerIdUsuarioAutenticado() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof Usuario) {
            Usuario usuario = (Usuario) authentication.getPrincipal();
            return usuario.getId();
        } else {
            throw new IllegalStateException("No hay un usuario autenticado o el principal no es de tipo Usuario");
        }
    }
}