package ru.stepup.spring.coins.limit.service;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import ru.stepup.spring.coins.limit.exception.LimitException;
import ru.stepup.spring.coins.limit.repository.LimitSettingRepository;

@Service
@RequiredArgsConstructor
public class LimitSettingService {
    private final LimitSettingRepository repository;

    @SneakyThrows
    public Float getLimit() {
        var setting = repository.findFirstByOrderById();
        return setting.orElseThrow(() -> new LimitException("EMPTY_SETTINGS", "Не заданы настройки лимитов")).getValue();
    }

    @SneakyThrows
    public void updateLimit(float newLimit) {
        var setting = repository.findFirstByOrderById();
        setting.ifPresentOrElse(x -> repository.save(x.setValue(newLimit)),
                () -> {
                    throw new LimitException("EMPTY_SETTINGS", "Не заданы настройки лимитов");
                });
    }
}
