package ru.stepup.spring.coins.limit.exception;

import lombok.Getter;

@Getter
public class LimitException extends RuntimeException{
    private String code;

    public LimitException(String code, String message) {
        super(message);
        this.code = code;
    }
}
