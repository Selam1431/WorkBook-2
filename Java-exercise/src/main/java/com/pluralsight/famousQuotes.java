package com.pluralsight;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;



public class famousQuotes {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        String[] quote = {
                "Stay strong.",
                "Dream big.",
                "Keep going.",
                "Trust yourself.",
                "Choose happiness.",
                "Never settle.",
                "Stay humble.",
                "Be fearless.",
                "Enjoy life.",
                "You got this."

        };
        String answer = "Yes";

        while (answer.equalsIgnoreCase("Yes")) {

            display(scanner, quote);

            System.out.print(" Do you want to see another quote? (Yes/ No):");
            answer = scanner.nextLine();
        }
        System.out.println(" GoodBye!");
        scanner.close();




        System.out.println(" Please select a number between 1 - 10! ");

        int number = scanner.nextInt();

    }

    public static void display(Scanner scanner, String[] quote) {
        try {
            System.out.print(" Choose A number 1 - 10 or 0 for random: ");
            // convert the string into integer
            int number = Integer.parseInt(scanner.nextLine());

            if (number == 0) {
                displayRandomQuote(quote);
            }else {
                // since the index start from zero
                System.out.println(quote[number - 1]);
            }
        } catch (NumberFormatException e) {
            System.out.println(" Invalid Input! Please enter a number.");
        } catch (ArrayIndexOutOfBoundsException e ) {
            System.out.println(" Please choose a number b/n 1 - 10");
        }
    }

    public static void displayRandomQuote(String[] quote) {
        Random random = new Random();

        int index = random.nextInt(quote.length);

        System.out.println(quote[index]);
    }

}
