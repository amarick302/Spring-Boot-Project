package com.example.spring_security.security.service;

import com.example.spring_security.entities.User;

import java.util.List;

public interface UserService {
    public User createUser(User user);
    public User findUserByUserName(String username);
    public List<User> findAllUser();
    public User updateUser(User user);
    public boolean deleteUser(int userId);
}
