package com.aluracursos.forohub.domain.topico;


import org.springframework.stereotype.Service;

@Service
public class TopicoService {

    private final TopicoRepository topicoRepository;

    public TopicoService(TopicoRepository topicoRepository) {
        this.topicoRepository = topicoRepository;
    }

    public void  usoTopico(){
        System.out.println("uso Topico");

    }



}
