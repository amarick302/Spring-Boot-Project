package com.example.spring_security.dao;

import com.example.spring_security.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User,Integer> {
    public User findUserByUsername(String username);
}
