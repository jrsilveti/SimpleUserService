package com.silveti.dailypsalmprovider.repository;


import com.silveti.dailypsalmprovider.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
