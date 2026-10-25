package cellphone_service;
import java.util.Scanner;


public class CellPhoneApplication {
    public static void main(String[] args) {
        CellPhone phone1 = new CellPhone();

        Scanner scanner = new Scanner(System.in);

        System.out.print(" What is the serial number: ");

        int serialNumber = scanner.nextInt();
        phone1.setSerialNumber(serialNumber);

        scanner.nextLine(); // clear the leftover Enter key

        System.out.print("What model is the phone: ");

        String model = scanner.nextLine();
        phone1.setModel(model);

        System.out.print(" Who is the carrier? ");

        String carrier = scanner.nextLine();

        phone1.setCarrier(carrier);


        System.out.print(" What is the phone number?");

        String phoneNumber = scanner.nextLine();

        phone1.setPhoneNumber(phoneNumber);

        System.out.print("who is the owner of the phone?");

        String owner = scanner.nextLine();

        phone1.setOwner(owner);

        System.out.println("Model: " + phone1.getModel());
        System.out.println("Serial Number: " + phone1.getSerialNumber());
        System.out.println("Carrier:  " + phone1.getCarrier());
        System.out.println("Phone number: " + phone1.getPhoneNumber());
        System.out.println("owner: " + phone1.getOwner());




    }

}
