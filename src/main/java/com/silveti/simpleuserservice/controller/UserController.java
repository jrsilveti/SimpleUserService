package com.silveti.simpleuserservice.controller;

import com.silveti.simpleuserservice.model.User;
import com.silveti.simpleuserservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:5173/")
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
