package com.ayseozcan.service;

import com.ayseozcan.entity.Yarisma;
import com.ayseozcan.repository.YarismaRepository;
import com.ayseozcan.utility.MyFactoryService;

public class YarismaService extends MyFactoryService<YarismaRepository, Yarisma, Long> {
    public YarismaService(){
        super(new YarismaRepository());
    }
}
