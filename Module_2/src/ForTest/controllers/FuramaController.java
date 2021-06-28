package ForTest.controllers;

import java.util.Scanner;

public class FuramaController {
    private static Scanner scanner = new Scanner(System.in);
    void displayMainMenu(){
        while (true){
            System.out.println("----Main Menu-----");
            System.out.println("1. Employee Management");
            System.out.println("2. Customer Management");
            System.out.println("3. Facility Management");
            System.out.println("4. Booking Management");
            System.out.println("5. Promotion Management");
            System.out.println("6. Exit");
            System.out.println("Your choice");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please try again");
            }
        }
    }

    void displayEmployeeManagement(){
        
    }
}
