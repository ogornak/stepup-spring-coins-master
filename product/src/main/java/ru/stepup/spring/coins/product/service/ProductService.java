package ru.stepup.spring.coins.product.service;

import ru.stepup.spring.coins.product.dto.ProductDto;

import java.util.List;

public interface ProductService {
    List<ProductDto> findAllProductByUserId(long userId);

    ProductDto findById(long productId);
}
