package com.gamma.gestorhorariosescolares.grupo.aplicacion.excepciones;

public class AsignacionInvalidaException extends Exception {

    public AsignacionInvalidaException() {
        super("No es posible asignar la inscripción al grupo");
    }

    public AsignacionInvalidaException(String mensaje) {
        super(mensaje);
    }

}