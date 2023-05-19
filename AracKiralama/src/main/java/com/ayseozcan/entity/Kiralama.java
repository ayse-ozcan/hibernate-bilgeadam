package com.ayseozcan.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "tbl_kiralama")
public class Kiralama {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate kiralamaBaslangic;
    private LocalDate kiralamaBitis;
    private double kiralamaUcreti;

    @ManyToOne
    @JoinColumn(name = "arac_id", referencedColumnName = "id") // column name i belirtmek icin
    private Arac arac;
    @ManyToOne
    private Musteri musteri;
}
