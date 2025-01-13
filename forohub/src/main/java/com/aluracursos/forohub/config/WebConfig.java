package com.aluracursos.forohub.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.util.UriComponentsBuilder;

@Configuration
public class WebConfig {

    @Bean
    public UriComponentsBuilder uriComponentsBuilder() {
        UriComponentsBuilder builder = UriComponentsBuilder.newInstance();
        return builder;
    }
}