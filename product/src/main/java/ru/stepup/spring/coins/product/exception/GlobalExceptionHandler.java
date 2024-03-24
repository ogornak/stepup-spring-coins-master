package ru.stepup.spring.coins.product.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.stepup.spring.coins.product.dto.ErrorDto;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorDto> handleProductNotFoundException(ProductNotFoundException e) {
        return new ResponseEntity<>(new ErrorDto("PRODUCT_NOT_FOUND", e.getMessage()),
                HttpStatus.BAD_REQUEST);
    }
}