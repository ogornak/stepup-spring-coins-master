package ru.stepup.spring.coins.core.services;

import org.springframework.stereotype.Service;
import ru.stepup.spring.coins.core.api.ProductResponse;
import ru.stepup.spring.coins.core.dtos.ProductDto;

@Service
public class InfoService {
    private final ProductService productService;

    public InfoService(ProductService productService) {
        this.productService = productService;
    }

    public ProductResponse getAllProductByUserId(int userId) {
        var productsDto = productService.getUserProducts(userId);
        return new ProductResponse(productsDto.products().stream().map(x -> new ProductDto(x.id(), x.account(),
                        x.balance(), x.type()))
                .toList());
    }
}
