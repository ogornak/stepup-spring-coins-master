package ru.stepup.spring.coins.product.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.stepup.spring.coins.product.entity.Product;
import ru.stepup.spring.coins.product.exception.ProductNotFoundException;
import ru.stepup.spring.coins.product.repository.ProductRepository;
import ru.stepup.spring.coins.product.service.ProductService;
import ru.stepup.spring.coins.product.service.UserService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final UserService userService;
    private final ProductRepository repository;

    @Override
    public List<Product> findAllProductByUserId(long userId) {
        var user = userService.findById(userId);
        return repository.findByAccount(user.getAccount());
    }

    @Override
    public Product findById(long productId) {
        var entity = repository.findById(productId);
        if (entity.isEmpty()) {
            throw new ProductNotFoundException("Product " + productId + " was not found");
        }
        return entity.get();
    }
}
