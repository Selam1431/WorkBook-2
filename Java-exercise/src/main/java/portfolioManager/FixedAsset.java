package portfolioManager;

import java.math.BigDecimal;

public abstract class FixedAsset implements Valuable{
    private String name;
    private double markerValue;

    public FixedAsset(String name, double markerValue) {
        this.name = name;
        this.markerValue = markerValue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMarkerValue() {
        return markerValue;
    }

    public void setMarkerValue(double markerValue) {
        this.markerValue = markerValue;
    }

    public abstract BigDecimal getValue();
}
