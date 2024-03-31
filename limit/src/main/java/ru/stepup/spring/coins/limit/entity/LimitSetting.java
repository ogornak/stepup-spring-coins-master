package ru.stepup.spring.coins.limit.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Entity
@Table(name = "limit_setting")
@Getter
@Setter
@Accessors(chain = true)
public class LimitSetting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Float value;
}
