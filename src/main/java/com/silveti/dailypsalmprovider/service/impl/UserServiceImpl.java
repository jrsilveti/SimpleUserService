package com.silveti.dailypsalmprovider.service.impl;

import com.silveti.dailypsalmprovider.model.User;
import com.silveti.dailypsalmprovider.repository.UserRepository;
import com.silveti.dailypsalmprovider.service.UserService;
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
