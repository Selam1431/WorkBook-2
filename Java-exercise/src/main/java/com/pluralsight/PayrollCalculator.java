package com.pluralsight;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PayrollCalculator {
    public static void main(String[] args) throws IOException {
        processName();

    }
    public static void processName()   {
        try (BufferedReader reader =
                     new BufferedReader(new FileReader("employees.csv"))) {
            reader.readLine();
            String line = reader.readLine();

            while (line != null) {
                String [] tokens = line.split("\\|");

                int employeeId = Integer.parseInt(tokens[0]);
                String name = tokens[1];
                double hoursWorked = Double.parseDouble(tokens[2]);
                double payRate = Double.parseDouble(tokens[3]);

                Employee employees = new Employee(employeeId, name, hoursWorked, payRate);

                System.out.printf("%s earned $%.2f%n",
                        employees.getName(),
                        employees.getGrossPay());

                line = reader.readLine();

            }
            reader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
