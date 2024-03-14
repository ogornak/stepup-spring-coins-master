package ru.stepup.spring.coins.product.repository;

import ru.stepup.spring.coins.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByUserId(long userId);
}
