package com.ayseozcan.services;

import com.ayseozcan.repository.entity.Goruntulenme;
import com.ayseozcan.repository.view.GoruntulenmeRepository;
import com.ayseozcan.utility.MyFactoryService;

public class GoruntulenmeService extends MyFactoryService<Goruntulenme,GoruntulenmeRepository > {
    public GoruntulenmeService(){
        super(new GoruntulenmeRepository());
    }
}
