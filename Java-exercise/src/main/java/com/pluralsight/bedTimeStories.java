package com.pluralsight;
import java.io.*;
import java.util.Scanner;



public class bedTimeStories {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        display();

        System.out.print(" Enter your choice (1 - 3) : ");

        int number = scanner.nextInt();

        String fileName = "";

        switch (number) {
            case 1:
                fileName = "goldilocks.txt";
                break;
            case 2:
                fileName = "hansel_and_gretel.txt";
                break;
            case 3:
                fileName = "mary_had_a_little_lamb.txt";
                break;
            default:
                System.out.println(" Invalid choice");



        }
        if (!fileName.isEmpty()) {
            readStory(fileName);
        }




        scanner.close();


    }

    public static void readStory(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {

            String line;

            int lineNumber = 1;

            while ((line = reader.readLine()) != null) {
                System.out.println(lineNumber + "." + line);
                lineNumber++;

            }

        } catch (IOException e) {
            System.out.println("Unable to read the file : " + e.getMessage());
        }
    }

    public static void display() {
        System.out.println("Welcome to Bedtime Stories!");
        System.out.println("We have three stories. Choose one to read:");
        System.out.println("1. Goldilocks and the Three Bears");
        System.out.println("2. Hansel and Gretel");
        System.out.println("3. Mary Had a Little Lamb");

    }
}
