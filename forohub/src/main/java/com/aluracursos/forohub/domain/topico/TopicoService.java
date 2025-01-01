package com.aluracursos.forohub.domain.topico;


import com.aluracursos.forohub.domain.usuario.Usuario;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Service
public class TopicoService {

    private final TopicoRepository topicoRepository;

    public TopicoService(TopicoRepository topicoRepository) {
        this.topicoRepository = topicoRepository;
    }


    public void  usoTopico(){
        System.out.println("uso Topico");

    }

    public LocalDateTime generaFechaActual(){
          return  LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
    }

    public void  generaObjTopico(RegistrarTopicoDTO datos , Usuario usuario, LocalDateTime fecha ){
        Topico Topico = topicoRepository.save(new Topico(datos, usuario, fecha));

    }



}
