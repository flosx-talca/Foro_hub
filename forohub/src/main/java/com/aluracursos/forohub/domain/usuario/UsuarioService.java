package com.aluracursos.forohub.domain.usuario;

import com.aluracursos.forohub.infraestructura.errores.ValidacionException;
import org.springframework.stereotype.Service;


@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void usoUsuario() {
        System.out.println("uso Usuario");

    }

    public Usuario traerUsuario(Long idUsuario) {
        return usuarioRepository.findById(idUsuario).get();
    }

    public Usuario buscarUsuario(Long id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new ValidacionException("Usuario no encontrado"));




        //  return usuarioRepository.findById(id)
        //        .orElseThrow(() -> new ValidacionException("Usuario no encontrado con id: " + id));
        /*Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (!usuario.isPresent()) {
            throw new ValidacionException("No existe usuario ");
        }
            Usuario usuarioEncontrado = usuario.get();
        return usuarioEncontrado;*/


    }



}

