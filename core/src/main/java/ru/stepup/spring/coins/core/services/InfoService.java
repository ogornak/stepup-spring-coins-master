package ru.stepup.spring.coins.core.services;

import org.springframework.stereotype.Service;
import ru.stepup.spring.coins.core.api.ProductResponse;

@Service
public class InfoService {
    private final ProductService productService;

    public InfoService(ProductService productService) {
        this.productService = productService;
    }

    public ProductResponse getAllProductByUserId(int userId) {
        return new ProductResponse(productService.getUserProducts(userId));
    }
}
