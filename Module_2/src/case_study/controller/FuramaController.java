package case_study.controller;

import case_study.services.*;

import java.util.Scanner;

public class FuramaController {
    public static Scanner input(){
        Scanner sc = new Scanner(System.in);
        return sc;
    }

    public void displayMenu(){
        while (true){
            System.out.println("----Menu----");
            System.out.println("1. Employee Management");
            System.out.println("2. Customer Management");
            System.out.println("3. Facility Management");
            System.out.println("4. Booking Management");
            System.out.println("5. Promotion Management");
            System.out.println("6. Exit");
            System.out.println("Your choice:");
            int choice = input().nextInt();
            switch (choice){
                case 1:
                    new EmployeeManagement().displayEmployeeManagement();
                    break;
                case 2:
                    new CustomerManagement().displayCustomerManagement();
                    break;
                case 3:
                    new FacilityManagement().displayFacilityManagement();
                    break;
                case 4:
                    new BookingManagement().displayBookingManagement();
                    break;
                case 5:
                    new PromotionManagement().displayPromotionManagement();
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong choice");
            }
        }
    }
}