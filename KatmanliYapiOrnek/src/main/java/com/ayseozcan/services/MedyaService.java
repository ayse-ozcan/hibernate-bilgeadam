package com.ayseozcan.services;

import com.ayseozcan.repository.entity.Goruntulenme;
import com.ayseozcan.repository.entity.Medya;
import com.ayseozcan.repository.view.GoruntulenmeRepository;
import com.ayseozcan.repository.view.MedyaRepository;
import com.ayseozcan.utility.MyFactoryService;

public class MedyaService extends MyFactoryService<Medya,MedyaRepository> {
    public MedyaService(){
        super(new MedyaRepository());
    }
}
