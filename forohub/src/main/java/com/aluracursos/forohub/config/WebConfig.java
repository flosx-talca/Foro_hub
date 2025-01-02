package com.aluracursos.forohub.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.util.UriComponentsBuilder;
/*
@Configuration
public class WebConfig {

    @Value("${app.base-url}") // Inyecta la URL base desde las propiedades
    private String baseUrl;

    @Bean
    public UriComponentsBuilder uriComponentsBuilder() {
        return UriComponentsBuilder.fromHttpUrl(baseUrl);
    }
}

*/

@Configuration
public class WebConfig {

    @Bean
    public UriComponentsBuilder uriComponentsBuilder() {
        UriComponentsBuilder builder = UriComponentsBuilder.newInstance();
        return builder;
    }
}