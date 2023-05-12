package com.banking.controller;

import com.banking.app.BAUtils;
import com.banking.entity.User;
import com.banking.service.UserService;

import java.util.HashMap;
import java.util.Optional;

public class UserController {

    private UserService userService;
    public UserController(){
        this.userService = new UserService();
    }
    public void saveUser(){
        String name = BAUtils.readString("isminizi girin");
        String email = BAUtils.readString("email girin");
        String password = BAUtils.readString("password girin");

        User user = new User(name,email,password);
        userService.save(user);
    }
    public User login() {
        String email = BAUtils.readString("email");
        String password = BAUtils.readString("password");
        Optional<User> userOptional = userService.findByEmail(email);
        return userOptional.get();
    }
}
