package ru.stepup.spring.coins.core.services;

import org.springframework.stereotype.Service;
import ru.stepup.spring.coins.core.dtos.ProductDto;
import ru.stepup.spring.coins.core.integrations.ProductIntegration;

import java.util.List;

@Service
public class ProductService {
    private final ProductIntegration integration;

    public ProductService(ProductIntegration integration) {
        this.integration = integration;
    }

    public ProductDto getProduct(int productId) {
        var product = integration.getProduct(productId);
        return new ProductDto(product.id(), product.account(), product.balance(), product.type());
    }

    public List<ProductDto> getUserProducts(int userId) {
        return integration.getUserProducts(userId).stream()
                .map(x -> new ProductDto(x.id(), x.account(), x.balance(), x.type()))
                .toList();
    }
}
