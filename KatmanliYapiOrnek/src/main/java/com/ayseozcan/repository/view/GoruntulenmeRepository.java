package com.ayseozcan.repository.view;

import com.ayseozcan.repository.entity.Goruntulenme;
import com.ayseozcan.utility.MyFactoryRepository;

public class GoruntulenmeRepository extends MyFactoryRepository<Goruntulenme,Long> {
    public GoruntulenmeRepository(){
        super(new Goruntulenme());
    }
}
