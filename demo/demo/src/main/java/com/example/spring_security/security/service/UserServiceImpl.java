package com.example.spring_security.security.service;

import com.example.spring_security.dao.UserDAO;
import com.example.spring_security.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserDAO userDAO;

    @Override
    public User createUser(User user) {
        return userDAO.save(user);
    }

    @Override
    public User findUserByUserName(String username) {
        return userDAO.findUserByUsername(username);
    }

    @Override
    public List<User> findAllUser() {
        return userDAO.findAll();
    }

    @Override
    public User updateUser(User user) {
        return userDAO.save(user);
    }

    @Override
    public boolean deleteUser(int userId) {
        User userToBeDeleted=userDAO.findById(userId).get();
        if(userToBeDeleted!=null){
            userDAO.delete(userToBeDeleted);
            return true;
        }
        return false;
    }
}
