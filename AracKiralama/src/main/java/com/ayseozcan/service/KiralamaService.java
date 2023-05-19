package com.ayseozcan.service;

import com.ayseozcan.entity.Kiralama;
import com.ayseozcan.repository.KiralamaRepository;
import com.ayseozcan.utility.MyFactoryService;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class KiralamaService extends MyFactoryService<KiralamaRepository, Kiralama,Long> {
    public KiralamaService() {
        super(new KiralamaRepository());
    }

    public List<Kiralama> tarihineKadarOlanKiralamalar(LocalDate date) {
        return getRepository().tarihineKadarOlanKiralamalar(date);
    }
}