package ru.stepup.spring.coins.core.services;

import org.springframework.stereotype.Service;
import ru.stepup.spring.coins.core.integrations.ProductIntegration;
import ru.stepup.spring.coins.core.integrations.dtos.ProductDtoRs;
import ru.stepup.spring.coins.core.integrations.dtos.ProductsDtoRs;

@Service
public class ProductService {
    private final ProductIntegration integration;

    public ProductService(ProductIntegration integration) {
        this.integration = integration;
    }

    public ProductDtoRs getProduct(int productId) {
        return integration.getProduct(productId);
    }

    public ProductsDtoRs getUserProducts(int userId) {
        return integration.getUserProducts(userId);
    }
}
