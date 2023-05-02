package com.ayseozcan.repository;

import com.ayseozcan.entity.YarismaKatilim;
import com.ayseozcan.utility.MyFactoryRepository;

public class YarismaKatilimRepository extends MyFactoryRepository<YarismaKatilim,Long> {
    public YarismaKatilimRepository(){
        super(new YarismaKatilim());
    }

}
