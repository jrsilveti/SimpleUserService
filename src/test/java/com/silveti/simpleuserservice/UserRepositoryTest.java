package com.silveti.simpleuserservice;

import com.silveti.simpleuserservice.model.User;
import com.silveti.simpleuserservice.repository.UserRepository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTest {

    public static final String TEST_EMAIL = "jose@magicmail.com";
    @Autowired
    private UserRepository userRepository;

    @Test
    public void saveUser() {
        User user = new User();
        user.setUserEmail(TEST_EMAIL);
        user.setUserName("jose");
        user.setUserPassword("123");
        User savedUser = userRepository.save(user);
        Assertions.assertNotNull(savedUser);
        Assertions.assertEquals(savedUser.getUserEmail(), TEST_EMAIL);
    }
}
