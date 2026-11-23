package com.pluralsight.portfolioManager;

import java.math.BigDecimal;

public  class Jewelry extends FixedAsset{
    private double karat;

    public Jewelry(String name, double marketValue, double karat) {
        super(name, marketValue);
        this.karat = karat;
    }


    public double getKarat() {
        return karat;
    }

    public void setKarat(double karat) {
        this.karat = karat;
    }


    @Override
    public BigDecimal getValue() {
        return BigDecimal.ZERO;
    }
}
