package com.pluralsight.Exercise;
import java.math.BigDecimal;


public class MoneyMath {
    public static void main(String[] args) {

        float floatValue = 0.0f;
        double doubleValue = 0.0;
        BigDecimal bigDecimalValue = BigDecimal.ZERO;

        System.out.println("First test: Adding 0.10");

        for (int i = 0; i < 10; i++) {
            floatValue += 0.10f;
            doubleValue +=  0.10;

            bigDecimalValue = bigDecimalValue.add(new BigDecimal("0.10")
            );

            System.out.println(
                    floatValue + " | " +
                    doubleValue + " | " +
                    bigDecimalValue

            );
        }
        floatValue = 0.0f;
        doubleValue = 0.0;
        bigDecimalValue = BigDecimal.ZERO;

        System.out.println("\nSECOND TEST: Adding 19.99");

        for (int i = 0; i < 1000; i++) {
            floatValue += 19.99f;
            doubleValue += 19.99;

            bigDecimalValue = bigDecimalValue.add(new BigDecimal("19.99")
            );
        }
        System.out.println("Float: " + floatValue);
        System.out.println("Double:" + doubleValue);
        System.out.println("BigDecimal: " + bigDecimalValue);

        System.out.println("\nCOMPARISON");

        System.out.println("Float vs Double: " +
                        ((double) floatValue == doubleValue));

        System.out.println("Double vs BigDecimal: " +
                        (BigDecimal.valueOf(doubleValue)
                                .compareTo(bigDecimalValue) == 0));

    }
}
