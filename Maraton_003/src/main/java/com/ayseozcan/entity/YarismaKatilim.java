package com.ayseozcan.entity;

import javax.persistence.*;

@Entity
@Table(name = "tbl_yarismakatilim")
public class YarismaKatilim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "yarisma_id")
    private Yarisma yarisma;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "kullanici_id")
    private Kullanici kullanici;
    public YarismaKatilim() {
    }

    public YarismaKatilim(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Yarisma getYarisma() {
        return yarisma;
    }

    public void setYarisma(Yarisma yarisma) {
        this.yarisma = yarisma;
    }

    public Kullanici getKullanici() {
        return kullanici;
    }

    public void setKullanici(Kullanici kullanici) {
        this.kullanici = kullanici;
    }

    @Override
    public String toString() {
        return "YarismaKatilim{" +
                "id=" + id +
                ", yarisma=" + yarisma +
                ", kullanici=" + kullanici +
                '}';
    }
}
