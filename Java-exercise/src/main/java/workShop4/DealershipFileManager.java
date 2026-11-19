package workShop4;
import java.io.*;
import java.math.BigDecimal;

public class DealershipFileManager {

    private static final String FILE = "inventory.csv";

    public Dealership getDealership() {

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(FILE))) {

            String line = reader.readLine();

            if (line == null) {
                throw new IllegalStateException("Inventory file is empty.");
            }

            String[] dealershipData = line.split("\\|");


            Dealership dealership = new Dealership(
                    dealershipData[0],
                    dealershipData[1],
                    dealershipData[2]
            );

            while ((line = reader.readLine()) != null) {

                if (line.isBlank()) {
                    continue;
                }

                String[] vehicleData = line.split("\\|");

                int vin = Integer.parseInt(vehicleData[0]);
                int year = Integer.parseInt(vehicleData[1]);
                String make = vehicleData[2];
                String model = vehicleData[3];
                String vehicleType = vehicleData[4];
                String color = vehicleData[5];
                int odometer = Integer.parseInt(vehicleData[6]);
                BigDecimal price = new BigDecimal(vehicleData[7]);

                Vehicle vehicle = new Vehicle(
                        vin,
                        year,
                        make,
                        model,
                        vehicleType,
                        color,
                        odometer,
                        price
                );

                dealership.addVehicle(vehicle);
            }

            return dealership;

        } catch (IOException e) {
            throw new IllegalStateException(
                    "Unable to read inventory file.", e
            );
        }
    }

    public void saveDealership(Dealership dealership) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE))) {

            writer.write(
                    dealership.getName() + "|" +
                            dealership.getAddress() + "|" +
                            dealership.getPhone()
            );
            writer.newLine();
            for (Vehicle vehicle : dealership.getAllVehicles()) {
                writer.write(
                        vehicle.getVin() + "|" +
                                vehicle.getYear() + "|" +
                                vehicle.getMake() + "|" +
                                vehicle.getModel() + "|" +
                                vehicle.getVehicleType() + "|" +
                                vehicle.getColor() + "|" +
                                vehicle.getOdometer() + "|" +
                                vehicle.getPrice().toPlainString()
                );
                writer.newLine();
            }
        }
         catch (IOException e) {
            throw new IllegalStateException(
                    "unable to save inventory.csv", e
            );
         }

    }
}
