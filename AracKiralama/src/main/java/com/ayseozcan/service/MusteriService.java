package com.ayseozcan.service;

import com.ayseozcan.entity.Arac;
import com.ayseozcan.entity.Musteri;
import com.ayseozcan.repository.MusteriRepository;
import com.ayseozcan.utility.MyFactoryService;

public class MusteriService extends MyFactoryService<MusteriRepository, Musteri,Long> {
    private AracService aracService = new AracService();
    public MusteriService(){
        super(new MusteriRepository());
    }

}
