package com.aluracursos.forohub.domain.topico.validaciones;

import com.aluracursos.forohub.Infraestructura.errores.ValidacionException;
import com.aluracursos.forohub.domain.topico.RegistrarTopicoDTO;
import com.aluracursos.forohub.domain.topico.TopicoRepository;
import org.springframework.stereotype.Component;

@Component
public class ValidaTituloMensajeUnicos  implements ValidadorTopico{

    private final TopicoRepository topicoRepository;

    public ValidaTituloMensajeUnicos(TopicoRepository topicoRepository) {
        this.topicoRepository = topicoRepository;
    }

    public void validar(RegistrarTopicoDTO datos){

        var titulo = datos.titulo().trim().replaceAll("\\s+", " ");
        var mensaje = datos.mensaje().trim().replaceAll("\\s+", " ");
        var tituloYMensaje = topicoRepository.existsByMensajeOrTitulo(mensaje, titulo);
        if (tituloYMensaje){
            throw new ValidacionException("El tirulo y mensaje ya existe en la BD");
        }


    }


}
