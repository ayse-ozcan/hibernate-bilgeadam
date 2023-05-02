package com.ayseozcan.service;

import com.ayseozcan.entity.Kullanici;
import com.ayseozcan.repository.KullaniciRepository;
import com.ayseozcan.utility.MyFactoryService;

import java.util.List;
import java.util.Optional;

public class KullaniciService extends MyFactoryService<KullaniciRepository, Kullanici,Long> {
    public KullaniciService(){
        super(new KullaniciRepository());
    }
    public List<Kullanici> listYarismayaKatilanlar(){
        return getRepository().listYarismayaKatilanlar();
    }

}
