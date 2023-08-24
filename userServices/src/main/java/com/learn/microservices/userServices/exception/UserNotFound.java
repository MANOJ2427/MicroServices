package com.learn.microservices.userServices.exception;

public class UserNotFound extends RuntimeException{
    public UserNotFound(){
        super("User Not Found !!");
    }
    public UserNotFound(String message){
        super(message);
    }
}
