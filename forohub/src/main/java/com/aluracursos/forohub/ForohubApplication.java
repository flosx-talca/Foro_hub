package com.aluracursos.forohub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ForohubApplication {

	public static void main(String[] args) {


		SpringApplication.run(ForohubApplication.class, args);

	}

// delete from flyway_schema_history where success = 0;  cuando no se detiene el proyecto al ahacer un migration
	// http://localhost:8080/medico?size=10&page=0&sort=nombre


}
