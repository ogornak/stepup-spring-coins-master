package ru.stepup.spring.coins.core.integrations;

import ru.stepup.spring.coins.core.integrations.dtos.ProductDtoRs;

import java.util.List;

public interface ProductIntegration {
    ProductDtoRs getProduct(int productId);

    List<ProductDtoRs> getUserProducts(int userID);
}
