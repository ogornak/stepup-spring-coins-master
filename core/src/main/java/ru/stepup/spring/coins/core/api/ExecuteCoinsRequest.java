package ru.stepup.spring.coins.core.api;

public record ExecuteCoinsRequest(
        String number,
        Integer productId,
        String productType
) {
}
