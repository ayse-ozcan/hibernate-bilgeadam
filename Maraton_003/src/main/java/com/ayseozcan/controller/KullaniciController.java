package com.ayseozcan.controller;

import com.ayseozcan.app.BAUtils;
import com.ayseozcan.entity.Kullanici;
import com.ayseozcan.entity.Yarisma;
import com.ayseozcan.entity.YarismaKatilim;
import com.ayseozcan.service.KullaniciService;
import com.ayseozcan.service.YarismaKatilimService;
import com.ayseozcan.service.YarismaService;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class KullaniciController {
    private KullaniciService kullaniciService;
    private YarismaService yarismaService;
    private YarismaKatilimService yarismaKatilimService;
    public KullaniciController(){
        this.kullaniciService = new KullaniciService();
        this.yarismaService = new YarismaService();
        this.yarismaKatilimService = new YarismaKatilimService();
    }
    public void saveKullanici(){

        Kullanici kullanici = new Kullanici();
        String ad = BAUtils.readString("adiniz");
        String soyad = BAUtils.readString("soyadiniz");
        String kimlikNo = BAUtils.readString("TC");
        String mail = BAUtils.readString("mail");
        int yas = BAUtils.readInt("yasiniz");
        kullanici.setAd(ad);
        kullanici.setSoyad(soyad);
        kullanici.setKimlikNo(kimlikNo);
        kullanici.setMail(mail);
        kullanici.setYas(yas);
        kullaniciService.save(kullanici);

        Yarisma yarisma = new Yarisma();
        String yarismaAd = BAUtils.readString("duzenlenecek yarismanin adi");
        String odul = BAUtils.readString("verilecek odul");
        yarisma.setAd(yarismaAd);
        yarisma.setOdul(odul);
        yarisma.setKullanici(kullanici);
        kullanici.getYarismaList().add(yarisma);
        yarismaService.save(yarisma);

        YarismaKatilim yarismaKatilim = new YarismaKatilim();
        yarismaKatilim.setKullanici(kullanici);
        yarismaKatilim.setYarisma(yarisma);
        yarismaKatilimService.save(yarismaKatilim);
    }
    public List<Kullanici> listYarismayaKatilanlar(){
        List<Kullanici> kullaniciList = kullaniciService.listYarismayaKatilanlar();
        kullaniciList.forEach(x->{ System.out.println("yarismaya katilan kullanici -> " + x.getKimlikNo());
        });
        return kullaniciList;
    }


}
