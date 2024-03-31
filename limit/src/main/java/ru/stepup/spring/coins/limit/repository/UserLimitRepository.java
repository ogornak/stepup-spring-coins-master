package ru.stepup.spring.coins.limit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.stepup.spring.coins.limit.entity.UserLimit;

import java.util.Optional;

public interface UserLimitRepository extends JpaRepository<UserLimit, Long> {
    @Modifying
    @Query(value = "update UserLimit set value = :limit ")
    void reset(@Param("limit") Float limit);

    Optional<UserLimit> findByUserId(Long userId);
}
