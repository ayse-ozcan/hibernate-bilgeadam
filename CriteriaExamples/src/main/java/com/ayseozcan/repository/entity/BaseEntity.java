
package com.ayseozcan.repository.entity;

import javax.persistence.Embeddable;

/**
 * Bu sinif, baska bir entity icine alan olarak eklenebilir.
 * Bu sinif eklendiginde DB de sinif adi ya da iliski olarak gorunmez.
 * Icinde bulunan alanlar tabl;oya yansitilir.
 *
 */
@Embeddable
public class BaseEntity {
    
    private Long createat;
    private Long updateat;
    private int state;

    public Long getCreateat() {
        return createat;
    }

    public void setCreateat(Long createat) {
        this.createat = createat;
    }

    public Long getUpdateat() {
        return updateat;
    }

    public void setUpdateat(Long updateat) {
        this.updateat = updateat;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
    
    
    
}
