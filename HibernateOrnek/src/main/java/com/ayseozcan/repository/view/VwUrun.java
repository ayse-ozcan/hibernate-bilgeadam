
package com.ayseozcan.repository.view;


public class VwUrun {
   
    private String ad;
    private String marka;

    public VwUrun() {
    }

    public VwUrun(String ad, String marka) {
        this.ad = ad;
        this.marka = marka;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    @Override
    public String toString() {
        return "VwUrun{" + "ad=" + ad + ", marka=" + marka + '}';
    }
    
    
}
