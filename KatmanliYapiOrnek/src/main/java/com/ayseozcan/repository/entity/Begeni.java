package com.ayseozcan.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "tbl_begeni")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Begeni {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long user_id;
    Long tweet_id;
    Long begeni_zamani;
}
