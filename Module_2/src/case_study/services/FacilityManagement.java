package case_study.services;

import case_study.controller.FuramaController;
import case_study.services.interface_service.FacilityServiceImpl;

import java.util.Scanner;

public class FacilityManagement {
    public static Scanner input(){
        Scanner sc = new Scanner(System.in);
        return sc;
    }
    public void displayFacilityManagement(){
        while (true){
            System.out.println("--Facility Management--");
            System.out.println("1. Display list facility");
            System.out.println("2. Add new facility");
            System.out.println("3. Edit facility");
            System.out.println("4. Return main menu");
            System.out.println("Your choice");
            int choice = input().nextInt();
            switch (choice){
                case 1:
                    new FacilityServiceImpl().display();
                    break;
                case 2:
                    new FacilityServiceImpl().add();
                    break;
                case 3:
                    new FacilityServiceImpl().edit();
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
