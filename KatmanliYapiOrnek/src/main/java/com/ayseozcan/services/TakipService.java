package com.ayseozcan.services;

import com.ayseozcan.repository.entity.Takip;
import com.ayseozcan.repository.view.TakipRepository;
import com.ayseozcan.utility.MyFactoryService;

public class TakipService extends MyFactoryService<Takip,TakipRepository> {

    public TakipService(){
        super(new TakipRepository());
    }
}

