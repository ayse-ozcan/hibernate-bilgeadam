package com.ayseozcan.controller;

import com.ayseozcan.entity.Musteri;
import com.ayseozcan.service.MusteriService;

import java.util.Optional;

public class MusteriController {
    private MusteriService musteriService;
    public MusteriController(){
        this.musteriService = new MusteriService();
    }

    public void saveKisi(Musteri musteri) {
        musteriService.save(musteri);
    }


    public Optional<Musteri> findById(long musteriId) {
        return musteriService.findById(musteriId);
    }

    public Musteri update(Musteri musteri) {
      return musteriService.update(musteri);
    }
}
