package ru.stepup.spring.coins.core.integrations;

import ru.stepup.spring.coins.core.integrations.dtos.ProductDtoRs;
import ru.stepup.spring.coins.core.integrations.dtos.ProductsDtoRs;

public interface ProductIntegration {
    ProductDtoRs getProduct(int productId);

    ProductsDtoRs getUserProducts(int userID);
}
