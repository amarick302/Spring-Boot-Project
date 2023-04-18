package com.example.spring_security.dao;

import com.example.spring_security.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDAO extends JpaRepository<User,Integer> {
     Optional<User> findUserByUsername(String username);
}
