package com.ayseozcan.services;

import com.ayseozcan.repository.entity.Takipci;
import com.ayseozcan.repository.entity.User;
import com.ayseozcan.repository.view.TakipciRepository;
import com.ayseozcan.utility.MyFactoryService;

import java.util.List;
import java.util.Optional;

public class TakipciService extends MyFactoryService<Takipci,TakipciRepository> {
    private final UserService userService;
    public TakipciService() {
        super(new TakipciRepository());
        userService = new UserService();
    }


    /**
     * Id si verilen kullanıcıyı takip eden kullanıcıların listesini döndürür.
     * @param id
     * @return
     */
    public List<User> findAllByUserId(Long id){

        List<Takipci> takipciList = repository.findByColumAndValue("user_id",id);
        takipciList.forEach(System.out::println);

        return null;
    }

    public void saveAndAdd(Takipci takipci){
        Optional<User> takip_edilen = userService.findById(takipci.getUser_id());
        Optional<User> takip_eden = userService.findById(takipci.getTakip_eden_id());
        if(takip_eden.isEmpty() || takip_edilen.isEmpty())
            return;
        save(takipci); // takip edilme işlemini kayıt ediyoruz.
        new UserService().addTakipciSayisi(takipci.getUser_id());
    }
}
