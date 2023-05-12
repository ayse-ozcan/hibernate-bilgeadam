package com.ayseozcan.repository.view;

import com.ayseozcan.repository.entity.Lokasyon;
import com.ayseozcan.utility.MyFactoryRepository;

public class LokasyonRepository extends MyFactoryRepository<Lokasyon,Long> {
    public LokasyonRepository(){
        super(new Lokasyon());
    }
}
