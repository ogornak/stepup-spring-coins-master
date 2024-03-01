package ru.stepup.spring.coins.product.controllers;

import ru.stepup.spring.coins.product.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.stepup.spring.coins.product.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService service;

    @GetMapping("/{id}")
    public ProductDto getByProductId(@PathVariable long id) {
        return service.findById(id);
    }

    @GetMapping("/user/{userId}")
    public List<ProductDto> getByUserId(@PathVariable long userId) {
        return service.findAllProductByUserId(userId);
    }
}
