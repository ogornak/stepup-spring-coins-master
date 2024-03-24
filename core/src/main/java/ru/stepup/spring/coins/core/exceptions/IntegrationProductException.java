package ru.stepup.spring.coins.core.exceptions;

public class IntegrationProductException extends RuntimeException {
    private String code;

    public IntegrationProductException(String code, String message) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
