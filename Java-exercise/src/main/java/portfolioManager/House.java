package portfolioManager;

import java.math.BigDecimal;

public  class House extends FixedAsset  {
    private int yearBuilt;
    private int squareFeet;
    private int bedrooms;

    public House(String name, double markerValue, int yearBuilt, int squareFeet, int bedrooms) {
        super(name, markerValue);
        this.yearBuilt = yearBuilt;
        this.squareFeet = squareFeet;
        this.bedrooms = bedrooms;
    }

    public int getYearBuilt() {
        return yearBuilt;
    }

    public void setYearBuilt(int yearBuilt) {
        this.yearBuilt = yearBuilt;
    }

    public int getSquareFeet() {
        return squareFeet;
    }

    public void setSquareFeet(int squareFeet) {
        this.squareFeet = squareFeet;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    @Override
    public BigDecimal getValue() {
        BigDecimal squareFeetValue = BigDecimal.valueOf(squareFeet).multiply(new BigDecimal("200"));
        BigDecimal bedroomValue = BigDecimal.valueOf(bedrooms).multiply(new BigDecimal("10000"));
        return squareFeetValue.add(bedroomValue);
    }
}
