package case_study.controller;

import case_study.controller.FuramaController;
import case_study.services.customer.CustomerServiceImpl;

import java.util.Scanner;

public class CustomerManagement {
    public static Scanner input(){
        Scanner sc = new Scanner(System.in);
        return sc;
    }
    public void displayCustomerManagement(){
        while (true){
            System.out.println("--Customer Management Menu--");
            System.out.println("1. Display list customer");
            System.out.println("2. Add new customer");
            System.out.println("3. Edit customer");
            System.out.println("4. Return main menu");
            System.out.println("Your choice");
            int choice =0;
            boolean checkValid = false;
            while(!checkValid){
                try {
                    choice = input().nextInt();
                    checkValid = true;
                } catch (NumberFormatException exception){
                    System.out.println("YOU MUST INPUT NUMBER!!!");
                }
            }
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
