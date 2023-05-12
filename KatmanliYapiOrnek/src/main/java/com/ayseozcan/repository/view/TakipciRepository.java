package com.ayseozcan.repository.view;

import com.ayseozcan.repository.entity.Takipci;
import com.ayseozcan.utility.MyFactoryRepository;

public class TakipciRepository extends MyFactoryRepository<Takipci,Long> {
    public TakipciRepository(){
        super(new Takipci());
    }
}
