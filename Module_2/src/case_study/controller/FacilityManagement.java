package case_study.controller;

import case_study.controller.FuramaController;
import case_study.services.facility.FacilityServiceImpl;

import java.util.Scanner;

public class FacilityManagement {
    public static Scanner input(){
        Scanner sc = new Scanner(System.in);
        return sc;
    }
    public void displayFacilityManagement(){
        while (true){
            System.out.println("--Facility Management Menu--");
            System.out.println("1. Display list facility");
            System.out.println("2. Add new facility");
            System.out.println("3. Display facility maintenance");
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
                    new FacilityServiceImpl().display();
                    break;
                case 2:
                    new FacilityServiceImpl().add();
                    break;
                case 3:
                    new FacilityServiceImpl().displayMaintenanceList();
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
