package ru.stepup.spring.coins.product.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class ProductsDto {
    private List<ProductDto> products;
}
