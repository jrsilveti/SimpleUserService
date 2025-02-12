package com.silveti.simpleuserservice.repository;


import com.silveti.simpleuserservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
