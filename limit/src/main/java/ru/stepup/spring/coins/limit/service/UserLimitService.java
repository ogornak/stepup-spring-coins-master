package ru.stepup.spring.coins.limit.service;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.stepup.spring.coins.limit.entity.UserLimit;
import ru.stepup.spring.coins.limit.exception.LimitException;
import ru.stepup.spring.coins.limit.repository.UserLimitRepository;

@Service
@RequiredArgsConstructor
public class UserLimitService {
    private final LimitSettingService limitSettingService;
    private final UserLimitRepository repository;

    @Scheduled(cron = "${schedulers.reset-limits}")
    public void reset() {
        var limit = limitSettingService.getLimit();
        repository.reset(limit);
    }

    public UserLimit get(long userId) {
        return repository.findByUserId(userId).orElse(new UserLimit());
    }

    public void debitCredit(long userId, Float debit, Float credit) {
        if (debit == null && credit == null) {
            throw new LimitException("ILLEGAL_ARGUMENT", "Пустые значения списания/зачисления");
        }
        if (credit != null) {
            credit(userId, credit);
        }
        if (debit != null) {
            debit(userId, debit);
        }
    }

    private void debit(long userId, float value) {
        var userLimit = repository.findByUserId(userId);
        userLimit.ifPresentOrElse(
                x -> repository.save(x.setValue(x.getValue() - value < 0 ? 0f : x.getValue() - value)),
                () -> repository.save(new UserLimit().setUserId(userId).setValue(limitSettingService.getLimit() - value))
        );
    }

    private void credit(long userId, float value) {
        var userLimit = repository.findByUserId(userId);
        userLimit.ifPresentOrElse(
                x -> repository.save(x.setValue(x.getValue() + value > limitSettingService.getLimit() ?
                        limitSettingService.getLimit() : x.getValue() + value)),
                () -> repository.save(new UserLimit().setUserId(userId).setValue(limitSettingService.getLimit()))
        );
    }
}
