package com.ayseozcan.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.print.attribute.standard.MediaSize;

@Entity
@Table(name = "tbl_takip")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Takip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long user_id;
    Long takip_edilen_id;
}
