package ru.stepup.spring.coins.product.service.impl;

import ru.stepup.spring.coins.product.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.stepup.spring.coins.product.entity.User;
import ru.stepup.spring.coins.product.exception.UserNotFoundException;
import ru.stepup.spring.coins.product.service.UserService;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    @Override
    public UserDto findById(long userId) {
        var user = userId == 1 ? new User().setId(1l).setAccount("123") : null;
        if (user == null) {
            throw new UserNotFoundException("User " + userId + " was not found");
        }
        return new UserDto().setId(userId).setAccount(user.getAccount());
    }
}
