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
        displayAddNewService();
    }

    @Override
    public void remove() {

    }

    @Override
    public void edit() {
        System.out.println("Input key");
        String key = input().nextLine();
        if (facilityMap.containsKey(key)){
            System.out.println("New Key");
            String newKey = input().nextLine();
            facilityMap.replace(newKey,facilityMap.get(key));
        }
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
                    addNewVilla();
                    break;
                case 2:
                    addNewHouse();
                    break;
                case 3:
                    addNewRoom();
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
        facilityMap.put("Villa",facilityMap.get("Villa")+1);
    }

    @Override
    public void addNewHouse() {
        facilityMap.put("House",facilityMap.get("House")+1);
    }

    @Override
    public void addNewRoom() {
        facilityMap.put("Room",facilityMap.get("Room")+1);
    }

}
