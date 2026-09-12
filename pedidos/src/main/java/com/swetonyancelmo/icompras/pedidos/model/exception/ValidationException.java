package com.swetonyancelmo.icompras.pedidos.model.exception;

import lombok.Getter;

@Getter
public class ValidationException extends RuntimeException {
    private String field;
    private String message;

    public ValidationException(String message, String field) {
        super(message);
        this.field = field;
        this.message = message;
    }
}
