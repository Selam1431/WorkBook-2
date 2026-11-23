
package workshop1;
import java.util.Scanner;

public class FinancialCalculator {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        boolean running = true;

        while (running) {
            System.out.println("\n===== FINANCIAL CALCULATORS =====");
            System.out.println("1. Mortgage Calculator");
            System.out.println("2. Future Value Calculator");
            System.out.println("3. Present Value Annuity Calculator");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    mortgageCalculator();
                    break;
                case 2:
                    futureValueCalculator();
                    break;
                case 3:
                    presentValueCalculator();
                    break;
                case 4:
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }

        scanner.close();
    }

    public static void mortgageCalculator() {

        System.out.println("\n===== MORTGAGE CALCULATOR =====");

        System.out.print("Enter loan principal: $");
        double principal = scanner.nextDouble();

        System.out.print("Enter annual interest rate (%): ");
        double annualRate = scanner.nextDouble();

        System.out.print("Enter loan term in years: ");
        int years = scanner.nextInt();

        if (principal <= 0 || annualRate < 0 || years <= 0) {
            System.out.println("Invalid input.");
            return;
        }

        double monthlyRate = annualRate / 100 / 12;
        int numberOfPayments = years * 12;

        double monthlyPayment;

        if (monthlyRate == 0) {
            monthlyPayment = principal / numberOfPayments;
        } else {
            double compound = Math.pow(1 + monthlyRate, numberOfPayments);

            monthlyPayment = principal *
                    (monthlyRate * compound) / (compound - 1);
        }

        double totalInterest =
                (monthlyPayment * numberOfPayments) - principal;

        System.out.printf("Monthly Payment: $%,.2f%n", monthlyPayment);
        System.out.printf("Total Interest: $%,.2f%n", totalInterest);
    }

    public static void futureValueCalculator() {

        System.out.println("\n===== FUTURE VALUE CALCULATOR =====");

        System.out.print("Enter initial deposit: $");
        double principal = scanner.nextDouble();

        System.out.print("Enter annual interest rate (%): ");
        double annualRate = scanner.nextDouble();

        System.out.print("Enter number of years: ");
        int years = scanner.nextInt();

        if (principal <= 0 || annualRate < 0 || years <= 0) {
            System.out.println("Invalid input.");
            return;
        }

        double rate = annualRate / 100;
        int daysPerYear = 365;
        int totalDays = daysPerYear * years;

        double futureValue = principal *
                Math.pow(1 + rate / daysPerYear, totalDays);

        double totalInterest = futureValue - principal;

        System.out.printf("Future Value: $%,.2f%n", futureValue);
        System.out.printf("Total Interest Earned: $%,.2f%n", totalInterest);
    }

    public static void presentValueCalculator() {

        System.out.println("\n===== PRESENT VALUE ANNUITY =====");

        System.out.print("Enter monthly payout: $");
        double monthlyPayout = scanner.nextDouble();

        System.out.print("Enter annual interest rate (%): ");
        double annualRate = scanner.nextDouble();

        System.out.print("Enter number of years: ");
        int years = scanner.nextInt();

        if (monthlyPayout <= 0 || annualRate < 0 || years <= 0) {
            System.out.println("Invalid input.");
            return;
        }

        double monthlyRate = annualRate / 100 / 12;
        int numberOfPayments = years * 12;

        double presentValue;

        if (monthlyRate == 0) {
            presentValue = monthlyPayout * numberOfPayments;
        } else {
            presentValue = monthlyPayout *
                    (1 - Math.pow(1 + monthlyRate, -numberOfPayments))
                    / monthlyRate;
        }

        System.out.printf("Present Value: $%,.2f%n", presentValue);
    }
}
