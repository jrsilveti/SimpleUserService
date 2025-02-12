package com.silveti.simpleuserservice.service.impl;

import com.silveti.simpleuserservice.model.User;
import com.silveti.simpleuserservice.repository.UserRepository;
import com.silveti.simpleuserservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

}
