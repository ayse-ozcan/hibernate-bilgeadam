package com.ayseozcan.service;

import com.ayseozcan.entity.User;
import com.ayseozcan.repository.UserRepository;
import com.ayseozcan.utility.MyFactoryService;


public class UserService extends MyFactoryService<User, UserRepository>{       
    public UserService(){
        super(new UserRepository());
    }    
    public boolean isUser(String username, String password){
         return repository.isUser(username, password);
    }    
}
