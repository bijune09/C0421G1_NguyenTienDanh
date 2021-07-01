package case_study.services.facility;

import case_study.models.facility.Facility;
import case_study.models.facility.House;
import case_study.models.facility.Room;
import case_study.models.facility.Villa;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FacilityServiceImpl implements FacilityService {
    public static Scanner input() {
        Scanner sc = new Scanner(System.in);
        return sc;
    }

    static boolean check = false;
    public static Map<Facility, Integer> facilityMap = new LinkedHashMap<>();
    static {
        //CE: tiêu chuẩn châu âu
        //TCVN
        Villa villa = new Villa("Ocean Villa", 150, 10000000, 10, "Day", "CE", 20, 2);
        House house = new House("Oat House", 100, 7000000, 8, "Week", "TCVN", 3);
        Room room = new Room("Jasmine Room", 50, 250000, 2, "Hours", "Netflix and snacks");
        facilityMap.put(villa, 0);
        facilityMap.put(house, 0);
        facilityMap.put(room, 0);
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

    }

    @Override
    public void display() {
        if (facilityMap.isEmpty()) {
            System.out.println("Nothing");
        } else {
            for (Map.Entry<Facility, Integer> facility : facilityMap.entrySet()) {
                System.out.println(facility);
            }
        }
    }

    @Override
    public void displayAddNewService() {
        while (true) {
            System.out.println("--Add new service--");
            System.out.println("1. Add New Villa");
            System.out.println("2. Add New House");
            System.out.println("3. Add New Room");
            System.out.println("4. Back to Menu");
            System.out.println("Choice:");
            int choice = input().nextInt();
            switch (choice) {
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
        for (Facility facility : facilityMap.keySet()) {
            if (facilityMap.containsKey(facility)) {
                facilityMap.put(facility, facilityMap.get(facility) + 1);
                break;
            }
        }
    }

    @Override
    public void addNewHouse() {
        for (Facility facility : facilityMap.keySet()) {
            if (facility.getName().equals("Oat House")) {
                if (facilityMap.get(facility) >= 5) {
                    System.out.println("Out of service");
                    break;
                }
                facilityMap.put(facility, facilityMap.get(facility) + 1);
            }
        }
    }

    @Override
    public void addNewRoom() {
        for (Facility facility : facilityMap.keySet()) {
            if (facility.getName().equals("Jasmine Room")) {
                if (facilityMap.get(facility) >= 5) {
                    System.out.println("Out of service");
                    break;
                }
                facilityMap.put(facility, facilityMap.get(facility) + 1);
            }
        }
    }

    @Override
    public void displayMaintenanceList() {
        for (Map.Entry<Facility, Integer> maintenanceFacilityList : facilityMap.entrySet()) {
            if (maintenanceFacilityList.getValue()>=5){
                System.out.println(maintenanceFacilityList);
            }
        }
    }

}
