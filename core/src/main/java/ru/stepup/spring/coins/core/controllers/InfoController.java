package ru.stepup.spring.coins.core.controllers;

import org.springframework.web.bind.annotation.*;
import ru.stepup.spring.coins.core.api.ProductResponse;
import ru.stepup.spring.coins.core.services.InfoService;

@RestController
@RequestMapping("/api/v1/info")
public class InfoController {
    private final InfoService infoService;

    public InfoController(InfoService infoService) {
        this.infoService = infoService;
    }

    @GetMapping("/user")
    public ProductResponse execute(@RequestHeader("USERID") Integer userId) {
        return infoService.getAllProductByUserId(userId);
    }
}
