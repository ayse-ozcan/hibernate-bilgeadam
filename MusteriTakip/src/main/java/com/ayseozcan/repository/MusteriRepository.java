
package com.ayseozcan.repository;

import com.ayseozcan.entity.Musteri;
import com.ayseozcan.utility.MyFactoryRepository;


public class MusteriRepository extends MyFactoryRepository<Musteri, Long>{
    
    public MusteriRepository(){
        super(new Musteri());
    }
    
}
