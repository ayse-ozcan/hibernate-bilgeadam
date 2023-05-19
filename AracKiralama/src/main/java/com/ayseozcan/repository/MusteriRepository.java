package com.ayseozcan.repository;

import com.ayseozcan.entity.Kiralama;
import com.ayseozcan.entity.Musteri;
import com.ayseozcan.utility.MyFactoryRepository;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class MusteriRepository extends MyFactoryRepository<Musteri,Long> {
    public MusteriRepository(){
        super(new Musteri());
    }

}
