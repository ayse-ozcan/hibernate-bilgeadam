package com.ayseozcan.services;

import com.ayseozcan.repository.entity.Lokasyon;
import com.ayseozcan.repository.view.LokasyonRepository;
import com.ayseozcan.utility.MyFactoryService;

public class LokasyonService extends MyFactoryService<Lokasyon,LokasyonRepository> {
    public LokasyonService() {
        super(new LokasyonRepository());

    }
}