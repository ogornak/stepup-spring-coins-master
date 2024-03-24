package ru.stepup.spring.coins.product.service;

import ru.stepup.spring.coins.product.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAllProductByUserId(long userId);

    Product findById(long productId);
}
