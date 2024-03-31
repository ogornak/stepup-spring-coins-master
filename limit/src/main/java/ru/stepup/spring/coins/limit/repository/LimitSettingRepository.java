package ru.stepup.spring.coins.limit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.stepup.spring.coins.limit.entity.LimitSetting;

import java.util.Optional;

public interface LimitSettingRepository extends JpaRepository<LimitSetting, Long> {
    Optional<LimitSetting> findFirstByOrderById();
}
