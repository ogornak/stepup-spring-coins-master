package ru.stepup.spring.coins.product.service.impl;

import ru.stepup.spring.coins.product.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.stepup.spring.coins.product.exception.ProductNotFoundException;
import ru.stepup.spring.coins.product.repository.ProductRepository;
import ru.stepup.spring.coins.product.service.ProductService;
import ru.stepup.spring.coins.product.service.UserService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final UserService userService;
    private final ProductRepository repository;

    @Override
    public List<ProductDto> findAllProductByUserId(long userId) {
        var user = userService.findById(userId);
        return repository.findByAccount(user.getAccount())
                .stream()
                .map(entity -> new ProductDto()
                        .setId(entity.getId())
                        .setAccount(entity.getAccount())
                        .setBalance(entity.getBalance())
                        .setType(entity.getType()))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDto findById(long productId) {
        var entity = repository.findById(productId);
        if (entity.isEmpty()) {
            throw new ProductNotFoundException("Product " + productId + " was not found");
        }
        return new ProductDto()
                .setId(productId)
                .setAccount(entity.get().getAccount())
                .setBalance(entity.get().getBalance())
                .setType(entity.get().getType());
    }
}
