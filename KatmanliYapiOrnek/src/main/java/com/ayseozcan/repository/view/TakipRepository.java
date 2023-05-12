package com.ayseozcan.repository.view;

import com.ayseozcan.repository.entity.Takip;
import com.ayseozcan.utility.MyFactoryRepository;

public class TakipRepository extends MyFactoryRepository<Takip,Long> {

    public TakipRepository() {
        super(new Takip());
    }
}
