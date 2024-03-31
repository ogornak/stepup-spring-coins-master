package ru.stepup.spring.coins.limit.controller;

import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.stepup.spring.coins.limit.dto.UserLimitDto;
import ru.stepup.spring.coins.limit.service.LimitSettingService;
import ru.stepup.spring.coins.limit.service.UserLimitService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/limits")
public class LimitController {
    private final LimitSettingService limitSettingService;
    private final UserLimitService userLimitService;

    @PutMapping("/setting")
    public void setLimit(@PathParam("limit") Float limit) {
        limitSettingService.updateLimit(limit);
    }

    @PutMapping
    public void debit(@RequestHeader(name = "USERID") Long userId,
                      @PathParam("debit") Float debit,
                      @PathParam("credit") Float credit) {
        userLimitService.debitCredit(userId, debit, credit);
    }

    @GetMapping
    public UserLimitDto getLimit(@RequestHeader(name = "USERID") Long userId) {
        var user = userLimitService.get(userId);
        return new UserLimitDto(user.getUserId(), user.getValue());
    }
}
