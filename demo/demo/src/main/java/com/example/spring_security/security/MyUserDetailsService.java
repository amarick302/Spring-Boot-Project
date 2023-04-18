package com.example.spring_security.security;

import com.example.spring_security.dao.UserDAO;
import com.example.spring_security.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {


    @Autowired
    UserDAO userDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userDAO.findUserByUsername(username);
        user.orElseThrow(()->new UsernameNotFoundException("Not Found "+username));
        return user.map(MyUserDetails::new).get();
    }
}
