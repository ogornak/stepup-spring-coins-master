package ru.stepup.spring.coins.product.service;

import ru.stepup.spring.coins.product.entity.User;

public interface UserService {
    User findById(long userId);
}
