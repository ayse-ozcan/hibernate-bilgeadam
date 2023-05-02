package com.ayseozcan.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tbl_kullanici")
public class Kullanici {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ad;
    private String soyad;
    private int yas;
    @Column(unique = true, nullable = false)
    private String kimlikNo;
    private String mail;
    @OneToMany(mappedBy = "kullanici", cascade = CascadeType.ALL)
    private List<Yarisma> yarismaList = new ArrayList<>();
    @OneToMany(mappedBy = "kullanici", cascade = CascadeType.ALL)
    private List<YarismaKatilim> yarismaKatilimList = new ArrayList<>();
    public Kullanici() {
    }

    public Kullanici(Long id, String ad, String soyad, int yas, String kimlikNo, String mail) {
        this.id = id;
        this.ad = ad;
        this.soyad = soyad;
        this.yas = yas;
        this.kimlikNo = kimlikNo;
        this.mail = mail;
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

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public int getYas() {
        return yas;
    }

    public void setYas(int yas) {
        this.yas = yas;
    }

    public String getKimlikNo() {
        return kimlikNo;
    }

    public void setKimlikNo(String kimlikNo) {
        this.kimlikNo = kimlikNo;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public List<Yarisma> getYarismaList() {
        return yarismaList;
    }

    public void setYarismaList(List<Yarisma> yarismaList) {
        this.yarismaList = yarismaList;
    }

    public List<YarismaKatilim> getYarismaKatilimList() {
        return yarismaKatilimList;
    }

    public void setYarismaKatilimList(List<YarismaKatilim> yarismaKatilimList) {
        this.yarismaKatilimList = yarismaKatilimList;
    }

    @Override
    public String toString() {
        return "Kullanici{" +
                "id=" + id +
                ", ad='" + ad + '\'' +
                ", soyad='" + soyad + '\'' +
                ", yas=" + yas +
                ", kimlikNo='" + kimlikNo + '\'' +
                ", mail='" + mail + '\'' +
                ", yarismaList=" + yarismaList +
                ", yarismaKatilimList=" + yarismaKatilimList +
                '}';
    }
}
