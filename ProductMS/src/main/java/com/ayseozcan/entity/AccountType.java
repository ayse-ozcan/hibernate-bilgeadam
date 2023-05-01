package com.ayseozcan.entity;

public enum AccountType {
    NORMAL(10),
    GOLD(50),
    PREMIUM(100);

    private final double indirimMiktari;

    AccountType(double indirimMiktari) {
        this.indirimMiktari = indirimMiktari;
    }

    public double getIndirimMiktari() {
        return indirimMiktari;
    }


}
