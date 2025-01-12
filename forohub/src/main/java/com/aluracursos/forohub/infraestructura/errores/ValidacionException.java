package com.aluracursos.forohub.infraestructura.errores;

public class ValidacionException extends RuntimeException {
    public ValidacionException(String message) {
        super(message);
    }
}
