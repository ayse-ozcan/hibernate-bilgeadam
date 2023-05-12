package com.ayseozcan.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "tbl_takipci")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Takipci {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long user_id;
    Long takip_eden_id;

}
