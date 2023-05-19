package com.ayseozcan.controller;

import com.ayseozcan.entity.Arac;
import com.ayseozcan.entity.EYakitTuru;
import com.ayseozcan.service.AracService;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class AracController {
    private AracService aracService;
    public AracController(){
        this.aracService = new AracService();
    }

    public void saveArac(Arac arac) {
        aracService.save(arac);
    }

    public List<Arac> findByMarkaAndModel(String marka, String model) {
        return aracService.findByMarkaAndModel(marka,model);
    }

    public List<Arac> findAllByDurum(boolean durum) {
        return aracService.findAllByDurum(durum);
    }

    public Optional<Arac> findById(long aracId) {
        return aracService.findById(aracId);
    }

    public void update(Arac arac) {
        aracService.update(arac);
    }

    public List<Arac> findByYakitTuru(EYakitTuru yakitTuru) {
        return aracService.findByYakitTuru(yakitTuru);
    }
    public List<Arac> findByMarkaAndModelStream(String marka, String model) {
        return aracService.findByMarkaAndModel(marka,model);
    }
    public List<Arac> findByYakitAndYilStream(EYakitTuru yakitTuru, LocalDate date){
        return aracService.findByYakitAndYilStream(yakitTuru,date);
    }

}
