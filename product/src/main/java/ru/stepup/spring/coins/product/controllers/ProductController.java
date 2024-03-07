package ru.stepup.spring.coins.product.controllers;

import ru.stepup.spring.coins.product.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.stepup.spring.coins.product.dto.ProductsDto;
import ru.stepup.spring.coins.product.service.ProductService;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService service;

    @GetMapping("/{id}")
    public ProductDto getByProductId(@PathVariable long id) {
        var product = service.findById(id);
        return new ProductDto()
                .setId(product.getId())
                .setAccount(product.getAccount())
                .setBalance(product.getBalance())
                .setType(product.getType());
    }

    @GetMapping("/user/{userId}")
    public ProductsDto getByUserId(@PathVariable long userId) {
        var list = service.findAllProductByUserId(userId)
                .stream()
                .map(entity -> new ProductDto()
                        .setId(entity.getId())
                        .setAccount(entity.getAccount())
                        .setBalance(entity.getBalance())
                        .setType(entity.getType()))
                .collect(Collectors.toList());
        return new ProductsDto().setProducts(list);
    }
}
