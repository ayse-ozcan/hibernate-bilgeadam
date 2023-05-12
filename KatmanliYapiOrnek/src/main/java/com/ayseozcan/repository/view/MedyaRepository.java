package com.ayseozcan.repository.view;

import com.ayseozcan.repository.entity.Medya;
import com.ayseozcan.utility.MyFactoryRepository;

public class MedyaRepository extends MyFactoryRepository<Medya,Long> {
    public MedyaRepository(){
        super(new Medya());
    }
}
