package com.eoi.ejemplospringboot.errorcontrol.exceptions;

import jakarta.persistence.EntityNotFoundException;

public class MiEntidadNoEncontradaException extends EntityNotFoundException {

    /**
     * Returns the detail message string of this throwable.
     *
     * @return the detail message string of this {@code Throwable} instance
     * (which may be {@code null}).
     */
    @Override
    public String getMessage() {
        return "La entidad no ha sido localizada";
    }
}
