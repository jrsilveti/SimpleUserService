package com.silveti.simpleuserservice.service;

import com.silveti.simpleuserservice.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User createUser(User user);
}
