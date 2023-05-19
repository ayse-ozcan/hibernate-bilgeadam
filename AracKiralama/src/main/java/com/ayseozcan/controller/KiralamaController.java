
package com.ayseozcan.controller;

import com.ayseozcan.entity.Kiralama;
import com.ayseozcan.service.KiralamaService;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class KiralamaController {
    private KiralamaService kiralamaService;
    public KiralamaController(){
        this.kiralamaService = new KiralamaService();
    }

    public void save(Kiralama kiralama) {
        kiralamaService.save(kiralama);
    }

    public List<Kiralama> tarihineKadarOlanKiralamalar(LocalDate date) {
       return kiralamaService.tarihineKadarOlanKiralamalar(date);
    }
    public List<Kiralama> findAll() {
        return kiralamaService.findAll();
    }
}
