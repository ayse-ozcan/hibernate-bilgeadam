package com.ayseozcan.services;

import com.ayseozcan.repository.entity.User;
import com.ayseozcan.repository.view.UserRepository;
import com.ayseozcan.utility.MyFactoryService;

import java.util.List;
import java.util.Optional;

public class UserService extends MyFactoryService<User,UserRepository> {

        public UserService(){
            super(new UserRepository());
        }
    public User findByUsername(String username){
        List<User> users = repository.findByColumAndValue("username",username);
        if(users.isEmpty())
            return null;
        return users.get(0);
    }

    /**
     * User Id si verilen kullanıcının takipçi sayısını 1 arttırır.
     * @param userid
     */
    public void addTakipciSayisi(Long userid){
        Optional<User> user = findById(userid); // Kullanıcıyı bulmayı deniyoruz.
        if(user.isEmpty()) // eğer böyle bir kullanıcı yok ise işlemi bitiriyoruz.
            return;
        User result = user.get(); // kullanıcıyı bulduk.
        result.setTakipci_sayisi(result.getTakipci_sayisi()+1);
        update(result);
    }
}
