package case_study.controller;

import case_study.controller.FuramaController;
import case_study.services.booking_and_contract.BookingServiceImpl;
import case_study.services.booking_and_contract.ContractServiceImpl;

import java.util.Scanner;

public class BookingManagement {
    public static Scanner input(){
        Scanner sc = new Scanner(System.in);
        return sc;
    }
    public void displayBookingManagement(){
        while (true){
            System.out.println("--Booking Management Menu--");
            System.out.println("1. Add new booking");
            System.out.println("2. Display list booking");
            System.out.println("3. Create new  contracts");
            System.out.println("4. Display list contracts");
            System.out.println("5. Edit contracts");
            System.out.println("6. Return menu");
            System.out.println("Your choice");
            int choice = input().nextInt();
            switch (choice){
                case 1:
                    new BookingServiceImpl().add();
                    break;
                case 2:
                    new BookingServiceImpl().display();
                    break;
                case 3:
                    new ContractServiceImpl().add();
                    break;
                case 4:
                    new ContractServiceImpl().display();
                    break;
                case 5:
                    new ContractServiceImpl().edit();
                    break;
                case 6:
                    new FuramaController().displayMenu();
                    break;
                default:
                    System.out.println("wrong");
            }
        }
    }
}
