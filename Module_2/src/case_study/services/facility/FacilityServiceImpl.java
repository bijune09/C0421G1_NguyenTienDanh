package case_study.services.facility;

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

    public static Map<String, Integer> facilityMaintenance = new LinkedHashMap<>();
    static {
        facilityMaintenance.put("Cooker",2);
        facilityMaintenance.put("Fan",2);
        facilityMaintenance.put("Air Conditioner",1);
        facilityMaintenance.put("Bicycle",5);
    }

    @Override
    public void add() {
        displayAddNewService();
    }

    @Override
    public void remove() {
    }

    //sai rooiiii
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
            System.out.println("Choice:");
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
        if (facilityMap.get("Villa")>5){
            System.out.println("Maintenance!!");
            facilityMap.put("Villa",facilityMap.get("Villa")-1);
        } else {
            facilityMap.put("Villa",facilityMap.get("Villa")+1);
        }
    }

    @Override
    public void addNewHouse() {
        if (facilityMap.get("House")>5){
            System.out.println("Maintenance!!");
            facilityMap.put("House",facilityMap.get("House")-1);
        } else {
            facilityMap.put("House",facilityMap.get("House")+1);
        }
    }

    @Override
    public void addNewRoom() {
        if (facilityMap.get("Room")>5){
            System.out.println("Maintenance!!");
            facilityMap.put("Room",facilityMap.get("Room")-1);
        } else {
            facilityMap.put("Room",facilityMap.get("Room")+1);
        }
    }

    @Override
    public void displayMaintenanceList() {
        if (facilityMaintenance.isEmpty()){
            System.out.println("Nothing");
        } else {
            for (Map.Entry<String,Integer> display: facilityMaintenance.entrySet()){
                System.out.println(display);
            }
        }
    }

}
