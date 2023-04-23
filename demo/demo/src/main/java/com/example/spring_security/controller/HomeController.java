package com.example.spring_security.controller;


import com.example.spring_security.dto.AuthRequest;
import com.example.spring_security.entities.User;
import com.example.spring_security.security.MyUserDetailsService;
import com.example.spring_security.service.JwtService;
import com.example.spring_security.service.JwtUtil;
import com.example.spring_security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
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
    JwtService jwtService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    JwtUtil jwtUtil;

    @GetMapping
    public ResponseEntity homePage(){
        return ResponseEntity.ok("This is Home Page");
    }


//    This is a simple authentication and jwt token generation when we use Jwt Service
//    @PostMapping("/authenticate")
//    public ResponseEntity<String> authenticateAndGetToken(@RequestBody AuthRequest auth){
//        Authentication authenticate =  authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(auth.getUsername(),auth.getPassword()));
//        if(authenticate.isAuthenticated()){
//            System.out.println("Authentication Successfull");
//            return ResponseEntity.status(HttpStatus.CREATED).body(jwtService.generateToken(auth.getUsername()));
//        }
//        else{
//            System.out.println(authenticate.isAuthenticated());
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Authentication Failed");
//        }
//    }

    @PostMapping("/authenticate")
    public ResponseEntity authenticateAndGetToken(@RequestBody AuthRequest auth)throws Exception{
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(auth.getUsername(),auth.getPassword()));
        }catch (BadCredentialsException e){
            throw new BadCredentialsException("Bad Credential");
        }
        UserDetails userDetails = userDetailsService.loadUserByUsername(auth.getUsername());
        return ResponseEntity.ok(jwtUtil.generateToken(userDetails));
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
