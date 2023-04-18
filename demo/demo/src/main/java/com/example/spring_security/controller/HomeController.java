package com.example.spring_security.controller;


import com.example.spring_security.entities.User;
import com.example.spring_security.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/v1/user")
public class HomeController {

    @Autowired
    UserService userService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> createUser(@RequestBody User user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(user));
    }

    @GetMapping(value = "/{username}")
    public ResponseEntity<User> findUserByUserName(@PathVariable String username){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.findUserByUserName(username));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public  ResponseEntity<List<User>> findAllUser(){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.findAllUser());
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> updateUser(@RequestBody User user){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.updateUser(user));
    }

    @DeleteMapping(value = "/{userId}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable int userId){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.deleteUser(userId));
    }
}