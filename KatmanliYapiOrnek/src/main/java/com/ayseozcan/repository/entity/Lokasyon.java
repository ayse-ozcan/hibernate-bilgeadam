package com.ayseozcan.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "tbl_lokasyon")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Lokasyon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    Long lon;
    Long lat;
}
