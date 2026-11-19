package workShop5;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ContractDataManager {
    private static final String FILE = "contracts.csv";

    // polymorphism
    public void saveContract(Contract contract) {
        // true append new information of over writing the existng file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE, true))) {

            writer.write(contract.getDateOfContract() + "|" +
                    contract.getCustomerName() + "|" +
                    contract.getCustomerEmail() + "|" +
                    contract.getVehicleSold().getVin() + "|"
            );


            if (contract instanceof SalesContract salesContract) {
                writer.write("SALE|");

            } else if ( contract instanceof LeaseContract leaseContract) {
                writer.write("LEASE|");
            }
            writer.write(contract.getTotalPrice() + "|" +
                    contract.getMonthlyPayment());

        } catch (IOException e) {
            throw new IllegalStateException("Unable to save contract.", e);
        }
    }

}
