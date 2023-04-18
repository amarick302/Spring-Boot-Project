package com.example.spring_security.controller;


import com.example.spring_security.entities.User;
import com.example.spring_security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class HomeController {

    @Autowired
    UserService userService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping
    public ResponseEntity homePage(){
        return ResponseEntity.ok("This is Home Page");
    }

//    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<User> createUser(@RequestBody User user){
//        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
//        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(user));
//    }
//
//    @GetMapping(value = "/{username}")
//    public ResponseEntity<Optional<User>> findUserByUserName(@PathVariable String username){
//        return ResponseEntity.status(HttpStatus.OK).body(userService.findUserByUserName(username));
//    }
//
//    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
//    public  ResponseEntity<List<User>> findAllUser(){
//        return ResponseEntity.status(HttpStatus.OK).body(userService.findAllUser());
//    }
//
//    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<User> updateUser(@RequestBody User user){
//        return ResponseEntity.status(HttpStatus.OK).body(userService.updateUser(user));
//    }
//
//    @DeleteMapping(value = "/{userId}")
//    public ResponseEntity<Boolean> deleteUser(@PathVariable int userId){
//        return ResponseEntity.status(HttpStatus.OK).body(userService.deleteUser(userId));
//    }
}
