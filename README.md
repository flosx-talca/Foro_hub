![forohub](https://github.com/user-attachments/assets/bbb2f1d3-4f6d-4d60-8c04-40ea9c5b0e2a)
# FORO HUB ALLURA - API REST

Este proyecto es una API REST construida con **Spring Boot**, enfocada en la gestión de tópicos mediante operaciones CRUD. La implementación destaca en la seguridad, autorización y autenticación **stateless** utilizando **JWT**. La API sigue buenas prácticas de desarrollo y está completamente documentada con **OpenAPI 3**.

## Características

- **Autenticación y autorización stateless** mediante JWT.
- **Gestión de Tópicos** con funcionalidades CRUD.
- **Documentación de la API** usando **OpenAPI 3**.
- **Buenas prácticas** en el diseño y desarrollo de la API.

## Dependencias

- **Spring Boot**: Framework principal para el desarrollo de la API.
- **Spring Security**: Implementación de autenticación y autorización.
- **JWT**: Para la autenticación sin estado.
- **Spring Data JPA**: Para la gestión de la persistencia de datos.
- **OpenAPI 3**: Para la documentación de la API.

## Instalación

1. Clona el repositorio:  
   `git clone https://github.com/flosx-talca/Foro_hub`
2. Accede a la carpeta del proyecto:  
   `cd foro_hub`
3. Construye el proyecto con Maven:  
   `mvn clean install`
4. Ejecuta la aplicación:  
   `mvn spring-boot:run`

## Documentación de la API

La API está completamente documentada utilizando **OpenAPI 3**, accesible a través de la siguiente URL cuando la aplicación esté en ejecución:  
`http://localhost:8080/swagger-ui/`


![DOC](https://github.com/user-attachments/assets/22fef33f-c082-4f96-8fe4-55ba0f2f1ed5)


## Contribuciones

Si deseas contribuir al proyecto, siéntete libre de enviar un **pull request** o abrir **issues**.
