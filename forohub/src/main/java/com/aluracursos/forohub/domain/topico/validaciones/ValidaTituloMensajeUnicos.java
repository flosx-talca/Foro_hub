package com.aluracursos.forohub.domain.topico.validaciones;

import com.aluracursos.forohub.infraestructura.errores.ValidacionException;
import com.aluracursos.forohub.domain.topico.TopicoRepository;
import org.springframework.stereotype.Component;

@Component
public class ValidaTituloMensajeUnicos  implements ValidadorTopico{

    private final TopicoRepository topicoRepository;

    public ValidaTituloMensajeUnicos(TopicoRepository topicoRepository) {
        this.topicoRepository = topicoRepository;
    }

    public void validar(String titulo, String mensaje, Long id){

        if (titulo != null && mensaje != null) {
            var mensajeFormat = mensaje.trim().replaceAll("\\s+", " ");
            var tituloFormat = titulo.trim().replaceAll("\\s+", " ");
            var tituloYMensaje = topicoRepository.existsByMensajeOrTitulo(mensajeFormat,tituloFormat );
            if (tituloYMensaje) {
                throw new ValidacionException("El Topico con este titulo y mensaje ya existe en la BD");
            }
        }


    }


}
