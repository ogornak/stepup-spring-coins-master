package ru.stepup.spring.coins.product.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ProductDto {
    private Long id;
    private String account;
    private Float balance;
    private String type;
}
