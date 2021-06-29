package case_study.services.interface_service;

import case_study.services.FacilityManagement;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FacilityServiceImpl implements FacilityService {
    public static Scanner input() {
        Scanner sc = new Scanner(System.in);
        return sc;
    }

    static boolean check = false;
    public static Map<String, Integer> facilityMap = new LinkedHashMap<>();

    static {
        facilityMap.put("Villa", 0);
        facilityMap.put("House", 0);
        facilityMap.put("Room", 0);
    }

    @Override
    public void add() {

    }

    @Override
    public void remove() {

    }

    @Override
    public void edit() {

    }

    @Override
    public void display() {
        if (facilityMap.isEmpty()) {
            System.out.println("Nothing");
        } else {
            for (Map.Entry<String, Integer> facility : facilityMap.entrySet()) {
                System.out.println(facility);
            }
        }
    }

    @Override
    public void displayAddNewService() {
        while (true){
            System.out.println("--Add new service");
            System.out.println("1. Add New Villa");
            System.out.println("2. Add New House");
            System.out.println("3. Add New Room");
            System.out.println("4. Back to Menu");
            System.out.println("Choice");
            int choice = input().nextInt();
            switch (choice){
                case 1:
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:
                    new FacilityManagement().displayFacilityManagement();
                    break;
                default:
                    System.out.println("Wrong choice");
            }
        }
    }

    @Override
    public void addNewVilla() {
        
    }

    @Override
    public void addNewHouse() {

    }

    @Override
    public void addNewRoom() {

    }

}
