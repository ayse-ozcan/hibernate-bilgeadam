package com.banking.service;

import com.banking.entity.User;
import com.banking.repository.UserRepository;
import com.banking.utility.MyFactoryService;

import java.util.Optional;

public class UserService extends MyFactoryService<UserRepository, User,Long> {
    public UserService(){
        super(new UserRepository());
    }

    public Optional<User> findByEmail(String email) {
       return getRepository().findByEmail(email);
    }
}
