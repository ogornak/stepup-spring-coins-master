package ru.stepup.spring.coins.product.service.impl;

import ru.stepup.spring.coins.product.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.stepup.spring.coins.product.repository.UserRepository;
import ru.stepup.spring.coins.product.service.UserService;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    @Override
    public UserDto findById(long userId) {
        var entity = repository.findById(userId);
        if (entity.isEmpty()) {
            throw new NoSuchElementException("User " + userId + " was not found");
        }
        return new UserDto().setId(userId).setAccount(entity.get().getAccount());
    }
}
