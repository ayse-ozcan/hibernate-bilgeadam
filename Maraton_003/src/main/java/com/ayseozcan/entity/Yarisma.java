package com.ayseozcan.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tbl_yarisma")
public class Yarisma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "yarisma_ad")
    private String ad;
    private LocalDate baslangicTarihi;
    private LocalDate bitisTarihi;
    private String odul;

    @OneToMany(mappedBy = "yarisma")
    private List<YarismaKatilim> yarismaKatilimList = new ArrayList<>();
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kullanici_id")
    private Kullanici kullanici;
    public Yarisma() {
    }

    public Yarisma(Long id, String ad, LocalDate baslangicTarihi, LocalDate bitisTarihi, String odul) {
        this.id = id;
        this.ad = ad;
        this.baslangicTarihi = baslangicTarihi;
        this.bitisTarihi = bitisTarihi;
        this.odul = odul;
    }

    public Yarisma(String ad, String odul) {
        this.ad = ad;
        this.odul = odul;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public LocalDate getBaslangicTarihi() {
        return baslangicTarihi;
    }

    public void setBaslangicTarihi(LocalDate baslangicTarihi) {
        this.baslangicTarihi = baslangicTarihi;
    }

    public LocalDate getBitisTarihi() {
        return bitisTarihi;
    }

    public void setBitisTarihi(LocalDate bitisTarihi) {
        this.bitisTarihi = bitisTarihi;
    }

    public String getOdul() {
        return odul;
    }

    public void setOdul(String odul) {
        this.odul = odul;
    }

    public List<YarismaKatilim> getYarismaKatilimList() {
        return yarismaKatilimList;
    }

    public void setYarismaKatilimList(List<YarismaKatilim> yarismaKatilimList) {
        this.yarismaKatilimList = yarismaKatilimList;
    }

    public Kullanici getKullanici() {
        return kullanici;
    }

    public void setKullanici(Kullanici kullanici) {
        this.kullanici = kullanici;
    }

    @Override
    public String toString() {
        return "Yarisma{" +
                "id=" + id +
                ", ad='" + ad + '\'' +
                ", baslangicTarihi=" + baslangicTarihi +
                ", bitisTarihi=" + bitisTarihi +
                ", odul='" + odul + '\'' +
                ", yarismaKatilimList=" + yarismaKatilimList +
                ", kullanici=" + kullanici +
                '}';
    }
}
