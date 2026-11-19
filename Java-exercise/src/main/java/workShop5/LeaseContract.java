package workShop5;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class LeaseContract extends Contract{

    public LeaseContract(String dateOfContract, String customerName, String customerEmail, Vehicle vehicleSold) {
        super(dateOfContract, customerName, customerEmail, vehicleSold);
        int currentYear = LocalDate.now().getYear();
        int vehicleAge = currentYear - vehicleSold.getYear();

    }

    public static boolean isEligibleForLease(Vehicle vehicle) {
        int currentYear = LocalDate.now().getYear();
        return currentYear - vehicle.getYear() <= 3;
    }



    public BigDecimal getExpectedEndingValue() {
        BigDecimal price = getVehicleSold().getPrice();
        BigDecimal endingValue = price.multiply(new BigDecimal("0.5"));
        return endingValue;

    }

    public BigDecimal getLeaseFee() {
        BigDecimal price = getVehicleSold().getPrice();
        BigDecimal leaseFee = price.multiply(new BigDecimal("0.07"));
        return leaseFee;
    }

    @Override
    public BigDecimal getTotalPrice() {
        return getExpectedEndingValue().add(getLeaseFee());
    }

    @Override
    public BigDecimal getMonthlyPayment() {
        BigDecimal annualRate = new BigDecimal("0.04");
        int month = 36;
        BigDecimal monthlyRate = annualRate.divide(new BigDecimal("12"), 10, RoundingMode.HALF_UP);

        BigDecimal leaseAmount = getTotalPrice();
        BigDecimal onePlusRate = BigDecimal.ONE.add(monthlyRate);
        BigDecimal power = onePlusRate.pow(month);
        BigDecimal numerator = power.multiply(monthlyRate);

        BigDecimal denominator = power.subtract(BigDecimal.ONE);
        BigDecimal divider = numerator.divide(denominator, 10, RoundingMode.HALF_UP);
        BigDecimal monthlyPayment = divider.multiply(leaseAmount);
        monthlyPayment = monthlyPayment.setScale(2, RoundingMode.HALF_UP);
        return monthlyPayment;


    }


}
