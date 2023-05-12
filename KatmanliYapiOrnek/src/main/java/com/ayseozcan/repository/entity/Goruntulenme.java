package com.ayseozcan.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "tbl_goruntulenme")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Goruntulenme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    Long tweet_id;
    Long user_id;

    Long goruntulenme_zamani;
}
