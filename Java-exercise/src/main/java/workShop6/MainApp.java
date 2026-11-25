package workShop6;

import java.awt.*;
import java.util.Scanner;
import java.awt.Color;
import java.awt.Point;


public class MainApp
{
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);

         System.out.println("Welcome To Turtle Paint!");

         System.out.println("Enter canvas width: ");
         int width = scanner.nextInt();

         System.out.println("Enter canvas height: ");
         int height = scanner.nextInt();

         World world = new World(width, height);
         Turtle turtle = new Turtle(world);

         int choice;

         do {
             System.out.println("\n===== Menu =====");
             System.out.println("1) Add shape");
             System.out.println("2) Save Image");
             System.out.println("4) Exit");

             System.out.println(" Enter Your Choice please: ");

             choice = scanner.nextInt();
             switch (choice) {
                 case 1:
                     addShape(scanner, turtle);
                     break;
                 case 2:
                     System.out.println("Save Image");
                     break;
                 case 4:
                     System.out.println("GoodBye");
                     break;
                 default:
                     System.out.println("Invalid Choice!");
             }
         } while (choice != 4);
         scanner.close();

    }
    public static void addShape(Scanner scanner, Turtle turtle) {

        System.out.println("\n===== ADD SHAPE =====");
        System.out.println("1) Square");
        System.out.println("2) Circle");
        System.out.println("3) Triangle");

        System.out.print("Which shape? ");
        int choice = scanner.nextInt();

        if (choice < 1 || choice > 3) {
            System.out.println("Invalid shape!");
            return;
        }

        System.out.print("Enter border width: ");
        int border = scanner.nextInt();

        System.out.print("Enter border color: ");
        String colorName = scanner.next();

        Color color = getColor(colorName);

        System.out.print("Enter x coordinate: ");
        int x = scanner.nextInt();

        System.out.print("Enter y coordinate: ");
        int y = scanner.nextInt();

        Point location = new Point(x, y);

        Shape shape;

        switch (choice) {
            case 1:
                System.out.print("Enter side length: ");
                int squareSide = scanner.nextInt();

                shape = new Square(turtle, location,
                        color, border, squareSide);
                break;

            case 2:
                System.out.print("Enter radius: ");
                int radius = scanner.nextInt();

                shape = new Circle(turtle, location,
                        color, border, radius);
                break;

            case 3:
                System.out.print("Enter side length: ");
                int triangleSide = scanner.nextInt();

                shape = new Triangle(turtle, location,
                        color, border, triangleSide);
                break;

            default:
                return;
        }

        shape.paint();

        System.out.println("Shape added successfully!");
    }
    public static Color getColor(String colorName) {

        return switch (colorName.toLowerCase()) {
            case "red" -> Color.RED;
            case "blue" -> Color.BLUE;
            case "green" -> Color.GREEN;
            case "yellow" -> Color.YELLOW;
            case "pink" -> Color.PINK;
            case "orange" -> Color.ORANGE;
            case "white" -> Color.WHITE;
            case "gray" -> Color.GRAY;
            case "black" -> Color.BLACK;
            default -> Color.BLACK;
        };
    }
}
