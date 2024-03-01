package ru.stepup.spring.coins.core.api;

import ru.stepup.spring.coins.core.dtos.ProductDto;

import java.util.List;

public record ProductResponse(List<ProductDto> products) {
}
