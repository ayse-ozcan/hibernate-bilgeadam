
package com.ayseozcan.repository.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tblpersonel")
public class Personel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String ad; 
    
    /**
     * @Enumareted(EnumType.String)
     * @OneToMany
     * @ElementCollection()
     * 
     */
    
    String unvani; // Enum kullanalim
    
    String adres; // adres listesi 
    String telefon; // telefon listesi
    
    
    
}
