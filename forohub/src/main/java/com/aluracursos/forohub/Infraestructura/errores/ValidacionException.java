package com.aluracursos.forohub.Infraestructura.errores;

public class ValidacionException extends RuntimeException {
    public ValidacionException(String message) {
        super(message);
    }
}
