package case_study.controller;

import case_study.controller.FuramaController;
import case_study.services.employee.EmployeeServiceImpl;

import java.util.Scanner;

public class EmployeeManagement {
    public static Scanner input(){
        Scanner sc = new Scanner(System.in);
        return sc;
    }
    public void displayEmployeeManagement(){
        while (true){
            System.out.println("--Employee Management Menu--");
            System.out.println("1. Display list employee.cvs");
            System.out.println("2. Add new employee.cvs");
            System.out.println("3. Edit employee.cvs");
            System.out.println("4. Return main menu");
            System.out.println("Your choice");
            int choice = input().nextInt();
            switch (choice){
                case 1:
                    new EmployeeServiceImpl().display();
                    break;
                case 2:
                    new EmployeeServiceImpl().add();
                    break;
                case 3:
                    new EmployeeServiceImpl().edit();
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
