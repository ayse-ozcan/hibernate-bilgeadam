package com.ayseozcan.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tbl_arac")
public class Arac {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marka;
    private String model;
    private LocalDate yil;
    @Enumerated(EnumType.STRING)
    private EYakitTuru eYakitTuru;
    @Enumerated(EnumType.STRING)
    private EVitesTipi eVitesTipi;
    private double fiyat;
    private boolean durum;

}
