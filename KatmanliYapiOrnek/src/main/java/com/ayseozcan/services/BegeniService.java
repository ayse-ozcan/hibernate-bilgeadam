package com.ayseozcan.services;

import com.ayseozcan.repository.entity.Begeni;
import com.ayseozcan.repository.view.BegeniRepository;
import com.ayseozcan.utility.MyFactoryService;

public class BegeniService extends MyFactoryService<Begeni,BegeniRepository> {
    public BegeniService(){
        super(new BegeniRepository());
    }
}
