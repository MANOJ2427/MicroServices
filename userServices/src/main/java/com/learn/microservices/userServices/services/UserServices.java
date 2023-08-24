package com.learn.microservices.userServices.services;

import com.learn.microservices.userServices.entities.Users;

import java.util.List;

public interface UserServices {

    Users saveUser(Users users);

    List<Users> getAllUser();

    Users getUser(String userId);

    Users deleteUser(String userId);
}
