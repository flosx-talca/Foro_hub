package com.aluracursos.forohub.domain.usuario;

import org.springframework.stereotype.Service;

import java.util.Optional;


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

        Optional<Usuario> usuario = usuarioRepository.findById(id);

        if (usuario.isPresent()) {
            Usuario usuarioEncontrado = usuario.get();
            // Procesar el usuario encontrado
            System.out.println("ENcontrado");


            return usuarioEncontrado;

        } else {
            // Manejar el caso en que no se encuentra el usuario
            System.out.println("hola");
        }
        return null;
    }
}





        //System.out.println(user.getMail());
        //return user;


