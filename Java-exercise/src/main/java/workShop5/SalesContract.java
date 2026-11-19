package workShop5;
import java.math.BigDecimal;
import java.math.RoundingMode;


public class SalesContract extends Contract {
    private boolean isFinanced;

    public SalesContract(String dateOfContract, String customerName, String customerEmail, Vehicle vehicleSold, boolean isFinanced) {
        super(dateOfContract, customerName, customerEmail, vehicleSold);

        this.isFinanced = isFinanced;
    }

    public boolean isFinanced() {
        return isFinanced;
    }

    public void setFinanced(boolean financed) {
        isFinanced = financed;
    }
    public BigDecimal getSalesTax() {

        BigDecimal price = getVehicleSold().getPrice();

        return price.multiply(new BigDecimal("0.05"));

    }
    public BigDecimal getRecordingFee() {

        return new BigDecimal("100");
    }
    public BigDecimal getProcessingFee() {
        BigDecimal price = getVehicleSold().getPrice();

        if (price.compareTo(new BigDecimal("10000")) < 0 ) {
            return new BigDecimal("295");
        } else {
            return new BigDecimal("495");
        }
    }

    @Override
    public BigDecimal getTotalPrice() {
        BigDecimal price = getVehicleSold().getPrice();
        BigDecimal withTax = price.add(getSalesTax());
        BigDecimal withRecording = withTax.add(getRecordingFee());
        BigDecimal withProcessing = withRecording.add(getProcessingFee());

        return withProcessing;
    }

    @Override
    public BigDecimal getMonthlyPayment() {

        if (!isFinanced) {
            return BigDecimal.ZERO;
        }
        BigDecimal price = getVehicleSold().getPrice();
        BigDecimal annualRate;
        int months;

        if (price.compareTo(new BigDecimal("10000")) < 0) {
            annualRate = new BigDecimal("0.0525");
            months = 24;
        } else {
            annualRate = new BigDecimal("0.0425");
            months = 48;
        }
        // keep 10 degit after the decimal point , rounds the result when necessary
        BigDecimal monthlyRate = annualRate.divide(new BigDecimal("12"), 10, RoundingMode.HALF_UP);
        BigDecimal loanAmount = getTotalPrice();

        // change the formula to java

        BigDecimal onePlusRate = BigDecimal.ONE.add(monthlyRate);
        BigDecimal power = onePlusRate.pow(months);

        BigDecimal numerator = monthlyRate.multiply(power);
        BigDecimal denominator = power.subtract(BigDecimal.ONE);

        BigDecimal divider = numerator.divide(denominator, 10, RoundingMode.HALF_UP);

        BigDecimal payment = divider.multiply(loanAmount);
        payment = payment.setScale(2, RoundingMode.HALF_UP);

        return payment;
    }


}
