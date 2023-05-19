package com.ayseozcan.service;

import com.ayseozcan.entity.Arac;
import com.ayseozcan.entity.EYakitTuru;
import com.ayseozcan.repository.AracRepository;
import com.ayseozcan.utility.MyFactoryService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class AracService extends MyFactoryService<AracRepository, Arac, Long> {
    public AracService() {
        super(new AracRepository());
    }

    public List<Arac> findByMarkaAndModel(String marka, String model) {
        return getRepository().findByMarkaAndModel(marka, model);

    }

    public List<Arac> findAllByDurum(boolean durum) {
        return getRepository().findAllByDurum(durum);
    }

    public List<Arac> findByYakitTuru(EYakitTuru yakitTuru) {
        return getRepository().findByYakitTuru(yakitTuru);
    }

    public Arac save(Arac arac) {
        if (isValidDate(arac.getYil())) {
            return getRepository().save(arac);
        }
        return null;
    }

    private boolean isValidDate(LocalDate date) {
        LocalDate currentDate = LocalDate.now();
        return date.isBefore(currentDate) || date.isEqual(currentDate);
    }

    public List<Arac> findByMarkaAndModelStream(String marka, String model) {
        List<Arac> aracList = getRepository().findAll()
                .stream()
                .filter(arac -> arac.getMarka().equals(marka) && arac.getModel().equals(model))
                .collect(Collectors.toList());
        return aracList;
    }

    public List<Arac> findByYakitAndYilStream(EYakitTuru yakitTuru, LocalDate date) {
        List<Arac> aracList = getRepository().findAll().stream()
                .filter(arac -> arac.getEYakitTuru().equals(yakitTuru) && arac.getYil().isBefore(date))
                .collect(Collectors.toList());
        return aracList;
    }

}
