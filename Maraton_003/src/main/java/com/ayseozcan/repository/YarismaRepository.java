package com.ayseozcan.repository;

import com.ayseozcan.entity.Yarisma;
import com.ayseozcan.utility.MyFactoryRepository;

public class YarismaRepository extends MyFactoryRepository<Yarisma,Long> {
    public YarismaRepository(){
        super(new Yarisma());
    }

}
