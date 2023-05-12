package com.ayseozcan.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "tbl_medya")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Medya {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String url;
    Long tweet_id;
    int medya_tipi;
    int state;

}
