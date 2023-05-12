package com.ayseozcan.repository.view;

import com.ayseozcan.repository.entity.User;
import com.ayseozcan.utility.MyFactoryRepository;

public class UserRepository extends MyFactoryRepository<User,Long> {

    public UserRepository() {
        super(new User());
    }
}
