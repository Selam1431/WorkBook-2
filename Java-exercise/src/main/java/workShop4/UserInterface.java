package workShop4;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private Dealership dealership;
    private final DealershipFileManager fileManager =
            new DealershipFileManager();

    private final Scanner scanner = new Scanner(System.in);

    // Load dealership information when the app starts
    private void init() {
        dealership = fileManager.getDealership();
    }


    public void display() {

        init();

        boolean running = true;

        while (running) {

            System.out.println("\n=================================");
            System.out.println("     " + dealership.getName());
            System.out.println("=================================");
            System.out.println("1 - Find vehicles by price range");
            System.out.println("2 - Find vehicles by make/model");
            System.out.println("3 - Find vehicles by year range");
            System.out.println("4 - Find vehicles by color");
            System.out.println("5 - Find vehicles by mileage range");
            System.out.println("6 - Find vehicles by type");
            System.out.println("7 - List ALL vehicles");
            System.out.println("8 - Add a vehicle");
            System.out.println("9 - Remove a vehicle");
            System.out.println("99 - Quit");

            int choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1 -> processGetByPriceRequest();
                case 2 -> processGetByMakeModelRequest();
                case 3 -> processGetByYearRequest();
                case 4 -> processGetByColorRequest();
                case 5 -> processGetByMileageRequest();
                case 6 -> processGetByVehicleTypeRequest();
                case 7 -> processGetAllVehiclesRequest();
                case 8 -> processAddVehicleRequest();
                case 9 -> processRemoveVehicleRequest();

                case 99 -> {
                    System.out.println("Goodbye!");
                    running = false;
                }

                default -> System.out.println("Invalid menu option.");
            }
        }
    }
    private void displayVehicles(List<Vehicle> vehicles) {

        if (vehicles == null || vehicles.isEmpty()) {
            System.out.println("No vehicles found.");
            return;
        }

        System.out.printf(
                "%-8s %-6s %-12s %-15s %-10s %-10s %-10s %s%n",
                "VIN", "YEAR", "MAKE", "MODEL",
                "TYPE", "COLOR", "MILEAGE", "PRICE"
        );

        System.out.println(
                "--------------------------------------------------------------------------"
        );

        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }

    private void processGetByPriceRequest() {

        BigDecimal min = readPrice("Minimum price: ");
        BigDecimal max = readPrice("Maximum price: ");

        displayVehicles(dealership.getVehiclesByPrice(min, max));
    }

    private void processGetByMakeModelRequest() {

        String make = readText("Enter make: ");
        String model = readText("Enter model: ");

        displayVehicles(
                dealership.getVehiclesByMakeModel(make, model)
        );
    }

    private void processGetByYearRequest() {

        int min = readInt("Minimum year: ");
        int max = readInt("Maximum year: ");

        displayVehicles(dealership.getVehiclesByYear(min, max));
    }

    private void processGetByColorRequest() {

        String color = readText("Enter color: ");

        displayVehicles(dealership.getVehiclesByColor(color));
    }

    private void processGetByMileageRequest() {

        int min = readInt("Minimum mileage: ");
        int max = readInt("Maximum mileage: ");

        displayVehicles(dealership.getVehiclesByMileage(min, max));
    }

    private void processGetByVehicleTypeRequest() {

        String type = readText("Enter vehicle type: ");

        displayVehicles(dealership.getVehiclesByType(type));
    }

    private void processGetAllVehiclesRequest() {

        displayVehicles(dealership.getAllVehicles());
    }

    private void processAddVehicleRequest() {

        System.out.println("\n--- Add Vehicle ---");

        int vin = readInt("VIN: ");

        if (findVehicleByVin(vin) != null) {
            System.out.println("A vehicle with this VIN already exists.");
            return;
        }

        int year = readInt("Year: ");
        String make = readText("Make: ");
        String model = readText("Model: ");
        String type = readText("Vehicle type: ");
        String color = readText("Color: ");
        int odometer = readInt("Mileage: ");
        BigDecimal price = readPrice("Price: ");

        Vehicle vehicle = new Vehicle(
                vin, year, make, model,
                type, color, odometer, price
        );

        dealership.addVehicle(vehicle);

        fileManager.saveDealership(dealership);

        System.out.println("Vehicle added successfully!");
    }

    private void processRemoveVehicleRequest() {

        System.out.println("\n--- Remove Vehicle ---");

        int vin = readInt("Enter VIN to remove: ");

        Vehicle vehicle = findVehicleByVin(vin);

        if (vehicle == null) {
            System.out.println("Vehicle not found.");
            return;
        }

        dealership.removeVehicle(vehicle);

        fileManager.saveDealership(dealership);

        System.out.println("Vehicle removed successfully!");
    }

    private Vehicle findVehicleByVin(int vin) {

        for (Vehicle vehicle : dealership.getAllVehicles()) {

            if (vehicle.getVin() == vin) {
                return vehicle;
            }
        }

        return null;
    }

    private String readText(String message) {

        System.out.print(message);
        return scanner.nextLine().trim();
    }

    private int readInt(String message) {

        while (true) {

            try {
                return Integer.parseInt(readText(message));

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid whole number.");
            }
        }
    }
    private BigDecimal readPrice(String message) {

        while (true) {

            try {
                return new BigDecimal(readText(message));

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid price.");
            }
        }
    }
}
