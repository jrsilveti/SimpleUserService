package com.silveti.dailypsalmprovider.controller;

import com.silveti.dailypsalmprovider.model.User;
import com.silveti.dailypsalmprovider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/hello")
    public String index() {
        return "Hello World!";
    }

    @PostMapping("create")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }
}
