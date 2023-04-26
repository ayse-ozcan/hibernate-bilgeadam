package com.ayseozcan.service;

import com.ayseozcan.entity.Musteri;
import com.ayseozcan.repository.MusteriRepository;
import com.ayseozcan.utility.MyFactoryService;


public class MusteriService extends MyFactoryService<Musteri, MusteriRepository>{
    public MusteriService(){
        super(new MusteriRepository());
    }  
}