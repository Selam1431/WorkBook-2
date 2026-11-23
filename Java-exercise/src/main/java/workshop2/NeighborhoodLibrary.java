
package workshop2;

import java.util.Scanner;

public class NeighborhoodLibrary {


    static Scanner scanner = new Scanner(System.in);


    static Book[] books = {
            new Book(1, "9780134685991", "Effective Java"),
            new Book(2, "9780132350884", "Clean Code"),
            new Book(3, "9780201633610", "Design Patterns"),
            new Book(4, "9781617294945", "Spring in Action"),
            new Book(5, "9780596009205", "Head First Java"),
            new Book(6, "9780134494166", "Clean Architecture"),
            new Book(7, "9781491950357", "Building Microservices"),
            new Book(8, "9780134757599", "Refactoring"),
            new Book(9, "9780131177055", "Working with Legacy Code"),
            new Book(10, "9780596517748", "JavaScript: The Good Parts"),
            new Book(11, "9781593275846", "Eloquent JavaScript"),
            new Book(12, "9781492052203", "Fluent Python"),
            new Book(13, "9780135957059", "The Pragmatic Programmer"),
            new Book(14, "9780262033848", "Introduction to Algorithms"),
            new Book(15, "9780131103627", "The C Programming Language"),
            new Book(16, "9780321125217", "Domain-Driven Design"),
            new Book(17, "9781449373320", "Designing Data-Intensive Applications"),
            new Book(18, "9780137081073", "The Clean Coder"),
            new Book(19, "9780134276717", "Soft Skills"),
            new Book(20, "9780132356138", "Agile Software Development")
    };

    public static void main(String[] args) {

        boolean running = true;

        while (running) {

            System.out.println("\n===== NEIGHBORHOOD LIBRARY =====");
            System.out.println("1. Show Available Books");
            System.out.println("2. Show Checked Out Books");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine();

            switch (choice) {

                case "1":
                    showAvailableBooks();
                    break;

                case "2":
                    showCheckedOutBooks();
                    break;

                case "3":
                    running = false;
                    System.out.println("Thank you for visiting!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        scanner.close();
    }


    public static void showAvailableBooks() {

        System.out.println("\n===== AVAILABLE BOOKS =====");

        System.out.printf("%-5s %-18s %-45s%n",
                "ID", "ISBN", "TITLE");

        boolean found = false;

        for (Book book : books) {

            if (!book.isCheckedOut()) {

                System.out.printf("%-5d %-18s %-45s%n",
                        book.getId(),
                        book.getIsbn(),
                        book.getTitle());

                found = true;
            }
        }

        if (!found) {
            System.out.println("No available books.");
            return;
        }

        System.out.print("\nEnter Book ID to check out (0 to go back): ");

        int id = readInt();

        if (id == 0) {
            return;
        }

        for (Book book : books) {

            if (book.getId() == id) {

                if (book.isCheckedOut()) {
                    System.out.println("This book is already checked out.");
                    return;
                }

                System.out.print("Enter your name: ");
                String name = scanner.nextLine().trim();

                if (name.isEmpty()) {
                    System.out.println("Name cannot be empty.");
                    return;
                }

                book.checkOut(name);

                System.out.println("Book checked out successfully!");
                System.out.println("Title: " + book.getTitle());
                System.out.println("Checked out to: " + name);

                return;
            }
        }

        System.out.println("Book ID not found.");
    }


    public static void showCheckedOutBooks() {

        System.out.println("\n===== CHECKED OUT BOOKS =====");

        System.out.printf("%-5s %-18s %-45s %-20s%n",
                "ID", "ISBN", "TITLE", "CHECKED OUT TO");

        boolean found = false;

        for (Book book : books) {

            if (book.isCheckedOut()) {

                System.out.printf("%-5d %-18s %-45s %-20s%n",
                        book.getId(),
                        book.getIsbn(),
                        book.getTitle(),
                        book.getCheckedOutTo());

                found = true;
            }
        }

        if (!found) {
            System.out.println("No books are currently checked out.");
        }

        System.out.println("\nC - Check In a Book");
        System.out.println("X - Return to Home Screen");
        System.out.print("Enter your choice: ");

        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("C")) {
            checkInBook();
        } else if (!choice.equalsIgnoreCase("X")) {
            System.out.println("Invalid choice. Returning to home.");
        }
    }


    public static void checkInBook() {

        System.out.print("Enter the Book ID to check in: ");

        int id = readInt();

        for (Book book : books) {

            if (book.getId() == id) {

                if (!book.isCheckedOut()) {
                    System.out.println("This book is not checked out.");
                    return;
                }

                book.checkIn();

                System.out.println("Book checked in successfully!");
                System.out.println("Title: " + book.getTitle());

                return;
            }
        }

        System.out.println("Book ID not found.");
    }


    public static int readInt() {

        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
            return -1;
        }
    }
}
