package com.silveti.dailypsalmprovider.service;

import com.silveti.dailypsalmprovider.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User createUser(User user);
}
