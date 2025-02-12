package com.silveti.dailypsalmprovider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PsalmController {

    @GetMapping("/psalm")
    public String index() {
        return "Hello World!";
    }
}
