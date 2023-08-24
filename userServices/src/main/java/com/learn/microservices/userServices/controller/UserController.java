package com.learn.microservices.userServices.controller;

import com.learn.microservices.userServices.entities.Users;
import com.learn.microservices.userServices.repositories.UserRepository;
import com.learn.microservices.userServices.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServices userServices;

    @PostMapping
    public ResponseEntity<Users> createUser(@RequestBody Users users){
        Users users1= userServices.saveUser(users);
        return ResponseEntity.status(HttpStatus.CREATED).body(users1);
    }
    @GetMapping("/{userId}")
    public ResponseEntity<Users> getUserById(@PathVariable String userId){
        Users users= userServices.getUser(userId);
        return ResponseEntity.ok(users);
    }

    @GetMapping
    public ResponseEntity<List<Users>> getAllUsers(){
        return ResponseEntity.ok(userServices.getAllUser());
    }

//    @DeleteMapping
//    public ResponseEntity<>

}
