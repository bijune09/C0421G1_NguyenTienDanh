package case_study.services;

import case_study.controller.FuramaController;

import java.util.Scanner;

public class PromotionManagement {
    public static Scanner input(){
        Scanner sc = new Scanner(System.in);
        return sc;
    }
    public void displayPromotionManagement(){
        while (true){
            System.out.println("--Promotion Management--");
            System.out.println("1. Display list customers use service");
            System.out.println("2. Display list customers get voucher");
            System.out.println("3. Return main menu");
            System.out.println("Your choice");
            int choice = input().nextInt();
            switch (choice){
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    new FuramaController().displayMenu();
                    break;
                default:
                    System.out.println("wrong");
            }
        }
    }
}
