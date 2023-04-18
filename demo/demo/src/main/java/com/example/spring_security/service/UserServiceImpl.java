package com.example.spring_security.service;

import com.example.spring_security.dao.UserDAO;
import com.example.spring_security.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserDAO userDAO;

    @Override
    public User createUser(User user) {
        return userDAO.save(user);
    }

    @Override
    public Optional<User> findUserByUserName(String username) {
        Optional<User> user=userDAO.findUserByUsername(username);
        System.out.println(user);
        return user;
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
        System.out.println(userToBeDeleted);
        if(userToBeDeleted!=null){
            userDAO.delete(userToBeDeleted);
            return true;
        }
        return false;
    }
}
