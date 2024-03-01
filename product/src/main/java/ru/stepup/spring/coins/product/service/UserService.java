package ru.stepup.spring.coins.product.service;

import ru.stepup.spring.coins.product.dto.UserDto;

public interface UserService {
    UserDto findById(long userId);
}
