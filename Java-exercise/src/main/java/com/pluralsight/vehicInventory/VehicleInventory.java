
package com.pluralsight.vehicInventory;

import java.util.Scanner;

public class VehicleInventory {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Vehicle[] vehicles = new Vehicle[20];

        int vehicleCount = 0;

        vehicles[0] = new Vehicle(101121, "Ford Explorer", "Red", 45000, 13500);
        vehicles[1] = new Vehicle(101122, "Toyota Camry", "Blue", 60000, 11000);
        vehicles[2] = new Vehicle(101123, "Chevrolet Malibu", "Black", 50000, 9700);
        vehicles[3] = new Vehicle(101124, "Honda Civic", "White", 70000, 7500);
        vehicles[4] = new Vehicle(101125, "Subaru Outback", "Green", 55000, 14500);
        vehicles[5] = new Vehicle(101126, "Jeep Wrangler", "Yellow", 30000, 16000);

        vehicleCount = 6;

        int command = 0;

        while (command != 6) {

            System.out.println("\nWelcome to Sel Car Dealer!");
            System.out.println("What do you want to do?");
            System.out.println("1 - List all vehicles");
            System.out.println("2 - Search by make/model");
            System.out.println("3 - Search by price range");
            System.out.println("4 - Search by color");
            System.out.println("5 - Add a vehicle");
            System.out.println("6 - Quit");

            System.out.print("Enter your command: ");
            command = scanner.nextInt();

            switch (command) {

                case 1: {
                    listAllVehicles(vehicles, vehicleCount);
                    break;
                }

                case 2: {
                    scanner.nextLine();

                    System.out.print("Enter make/model: ");
                    String makeModel = scanner.nextLine();

                    searchByMakeModel(vehicles, vehicleCount, makeModel);
                    break;
                }

                case 3: {
                    System.out.print("Enter minimum price: ");
                    double minPrice = scanner.nextDouble();

                    System.out.print("Enter maximum price: ");
                    double maxPrice = scanner.nextDouble();

                    if (minPrice > maxPrice) {
                        System.out.println("Minimum price cannot be greater than maximum. Please enter new numbers.");
                    } else {
                        searchByPrice(vehicles, vehicleCount, minPrice, maxPrice);
                    }

                    break;
                }

                case 4: {
                    scanner.nextLine();

                    System.out.print("Enter your color: ");
                    String color = scanner.nextLine();

                    searchByColor(vehicles, vehicleCount, color);
                    break;
                }

                case 5: {
                    if (vehicleCount >= vehicles.length) {
                        System.out.println("Inventory is full!");
                        break;
                    }

                    System.out.print("Enter vehicle ID: ");
                    long vehicleId = scanner.nextLong();

                    scanner.nextLine();

                    System.out.print("Enter make/model: ");
                    String makeModel = scanner.nextLine();

                    System.out.print("Enter color: ");
                    String color = scanner.nextLine();

                    System.out.print("Enter odometer reading: ");
                    int odometerReading = scanner.nextInt();

                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();

                    Vehicle newVehicle = new Vehicle(
                            vehicleId, makeModel, color, odometerReading, price
                    );

                    vehicles[vehicleCount] = newVehicle;
                    vehicleCount++;

                    System.out.println("Vehicle added successfully!");
                    break;
                }

                case 6: {
                    System.out.println("Goodbye!");
                    break;
                }

                default: {
                    System.out.println("Invalid command. Please try again.");
                    break;
                }
            }
        }

        scanner.close();
    }

    public static void listAllVehicles(Vehicle[] vehicles, int vehicleCount) {

        for (int i = 0; i < vehicleCount; i++) {
            Vehicle vehicle = vehicles[i];
            System.out.println(vehicle);
        }
    }

    public static void searchByMakeModel(
            Vehicle[] vehicles, int vehicleCount, String makeModel) {

        boolean found = false;

        for (int i = 0; i < vehicleCount; i++) {
            Vehicle vehicle = vehicles[i];

            if (vehicle.getMakeModel().equalsIgnoreCase(makeModel)) {
                System.out.println(vehicle);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching vehicle found. Sorry.");
        }
    }

    public static void searchByPrice(
            Vehicle[] vehicles, int vehicleCount,
            double minPrice, double maxPrice) {

        boolean found = false;

        for (int i = 0; i < vehicleCount; i++) {
            Vehicle vehicle = vehicles[i];

            if (vehicle.getPrice() >= minPrice &&
                    vehicle.getPrice() <= maxPrice) {
                System.out.println(vehicle);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching vehicle found. Sorry.");
        }
    }

    public static void searchByColor(
            Vehicle[] vehicles, int vehicleCount, String color) {

        boolean found = false;

        for (int i = 0; i < vehicleCount; i++) {
            Vehicle vehicle = vehicles[i];

            if (vehicle.getColor().equalsIgnoreCase(color)) {
                System.out.println(vehicle);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching vehicle found. Sorry.");
        }
    }
}
