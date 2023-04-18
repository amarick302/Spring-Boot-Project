package com.example.spring_security.service;

import com.example.spring_security.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public User createUser(User user);
    public Optional<User> findUserByUserName(String username);
    public List<User> findAllUser();
    public User updateUser(User user);
    public boolean deleteUser(int userId);
}
