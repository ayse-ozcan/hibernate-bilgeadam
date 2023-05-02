package com.ayseozcan.service;

import com.ayseozcan.entity.YarismaKatilim;
import com.ayseozcan.repository.YarismaKatilimRepository;
import com.ayseozcan.utility.MyFactoryService;

public class YarismaKatilimService extends MyFactoryService<YarismaKatilimRepository, YarismaKatilim,Long> {
    public YarismaKatilimService(){
        super(new YarismaKatilimRepository());
    }
}
