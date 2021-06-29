package case_study.services;

import case_study.controller.FuramaController;
import case_study.services.interface_service.CustomerServiceImpl;

import java.util.Scanner;

public class CustomerManagement {
    public static Scanner input(){
        Scanner sc = new Scanner(System.in);
        return sc;
    }
    public void displayCustomerManagement(){
        while (true){
            System.out.println("--Customer Management--");
            System.out.println("1. Display list customer");
            System.out.println("2. Add new customer");
            System.out.println("3. Edit customer");
            System.out.println("4. Return main menu");
            System.out.println("Your choice");
            int choice = input().nextInt();
            switch (choice){
                case 1:
                    new CustomerServiceImpl().display();
                    break;
                case 2:
                    new CustomerServiceImpl().add();
                    break;
                case 3:
                    new CustomerServiceImpl().edit();
                    break;
                case 4:
                    new FuramaController().displayMenu();
                    break;
                default:
                    System.out.println("wrong");
            }
        }
    }
}
