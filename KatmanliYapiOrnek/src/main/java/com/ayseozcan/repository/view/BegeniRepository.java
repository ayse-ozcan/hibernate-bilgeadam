package com.ayseozcan.repository.view;

import com.ayseozcan.repository.entity.Begeni;
import com.ayseozcan.utility.MyFactoryRepository;

public class BegeniRepository  extends MyFactoryRepository<Begeni, Long> {
    public BegeniRepository(){
        super(new Begeni());
    }
}
