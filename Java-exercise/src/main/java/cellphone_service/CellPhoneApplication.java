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

        // creating second phone

        CellPhone phone2 = new CellPhone();

        System.out.println(" \n ==== phone2 ====");

        System.out.println("What is the serial number? ");

        int serialNumber2 = scanner.nextInt();
        phone2.setSerialNumber(serialNumber2);

        scanner.nextLine();

        System.out.println("What model is the phone? ");

        String model2 = scanner.nextLine();

        phone2.setModel(model2);

        System.out.println("Who is the carrier? ");

        String carrier2 = scanner.nextLine();

        phone2.setCarrier(carrier2);

        System.out.println("What is the phone number? ");

        String phoneNumber2 = scanner.nextLine();

        phone2.setPhoneNumber(phoneNumber2);

        System.out.println("Who is the owner of the phone? ");

        String owner2 = scanner.nextLine();

        phone2.setOwner(owner2);

        System.out.println("\n ==== phone 1 information ====");
        display(phone1);

        System.out.println("\n ==== phone 2 information =====");


        display(phone2);

        phone1.dial(phone2.getPhoneNumber());

        phone2.dial(phone1.getPhoneNumber());






        scanner.close();




    }
    public static void display(CellPhone phone){
        System.out.println("Model: " + phone.getModel());
        System.out.println("Serial Number: " + phone.getSerialNumber());
        System.out.println("Carrier:  " + phone.getCarrier());
        System.out.println("Phone number: " + phone.getPhoneNumber());
        System.out.println("owner: " + phone.getOwner());
    }


}
