package case_study.services.facility;

import case_study.controller.FacilityManagement;
import case_study.models.facility.Facility;
import case_study.models.facility.House;
import case_study.models.facility.Room;
import case_study.models.facility.Villa;
import case_study.utils.read_and_write_file.ReadAndWriteFile;
import jdk.internal.org.objectweb.asm.tree.LdcInsnNode;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FacilityServiceImpl extends ReadAndWriteFile implements FacilityService {
    private static final String FILE_PATH_VILLA
<<<<<<< HEAD
            = "D:\\C0421G1_NguyenTienDanh\\Module_2\\src\\case_study\\data\\villa.csv";
    private static final String FILE_PATH_HOUSE
            = "D:\\C0421G1_NguyenTienDanh\\Module_2\\src\\case_study\\data\\house.csv";
    private static final String FILE_PATH_ROOM
            = "D:\\C0421G1_NguyenTienDanh\\Module_2\\src\\case_study\\data\\room.csv";
=======
            = "D:\\C0421G1_NguyenTienDanh_New\\C0421G1_NguyenTienDanh\\Module_2\\src\\case_study\\data\\villa.csv";
    private static final String FILE_PATH_HOUSE
            = "D:\\C0421G1_NguyenTienDanh_New\\C0421G1_NguyenTienDanh\\Module_2\\src\\case_study\\data\\house.csv";
    private static final String FILE_PATH_ROOM
            = "D:\\C0421G1_NguyenTienDanh_New\\C0421G1_NguyenTienDanh\\Module_2\\src\\case_study\\data\\room.csv";
>>>>>>> e84db6c9c9dc6c1c095e1f67df68f1b60ddb3f28

    public static Scanner input() {
        Scanner sc = new Scanner(System.in);
        return sc;
    }

    static boolean check = false;
    public static Map<Facility, Integer> facilityMap = new LinkedHashMap<>();

    private void readFacilityFromFile() {
        List<String> houseLine = readFile(FILE_PATH_HOUSE);
        for (String line : houseLine) {
            String[] splitLine = line.split(",");
            House house = new House(splitLine[0], Double.parseDouble(splitLine[1]), Double.parseDouble(splitLine[2]),
                    Integer.parseInt(splitLine[3]), splitLine[4], splitLine[5], Integer.parseInt(splitLine[6]));
            facilityMap.put(house, Integer.parseInt(splitLine[7]));
        }
        List<String> villaLine = readFile(FILE_PATH_VILLA);
        for (String line : villaLine) {
            String[] splitLine = line.split(",");
            Villa villa = new Villa(splitLine[0], Double.parseDouble(splitLine[1]), Double.parseDouble(splitLine[2]),
                    Integer.parseInt(splitLine[3]), splitLine[4], splitLine[5], Double.parseDouble(splitLine[6]),
                    Integer.parseInt(splitLine[7]));
            facilityMap.put(villa, Integer.parseInt(splitLine[8]));
        }
        List<String> roomLine = readFile(FILE_PATH_ROOM);
        for (String line : roomLine) {
            String[] splitLine = line.split(",");
            Room room = new Room(splitLine[0], Double.parseDouble(splitLine[1]), Double.parseDouble(splitLine[2]),
                    Integer.parseInt(splitLine[3]), splitLine[4], splitLine[5]);
            facilityMap.put(room, Integer.parseInt(splitLine[6]));
        }
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
        readFacilityFromFile();
        if (facilityMap.isEmpty()) {
            System.out.println("Nothing");
        } else {
            for (Map.Entry<Facility, Integer> facility : facilityMap.entrySet()) {
                System.out.println(facility);
            }
        }
        facilityMap.clear();
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
                    displayAddNewVilla();
                    break;
                case 2:
                    displayAddNewHouse();
                    break;
                case 3:
                    displayAddNewRoom();
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
    public void displayAddNewVilla() {
        while (true) {
            System.out.println("---You have 2 choices---");
            System.out.println("1. Add a whole new Villa");
            System.out.println("2. Use available Villa");
            System.out.println("3. Back to menu");
            System.out.println("Your choice:");
            int choice = input().nextInt();
            switch (choice) {
                case 1:
                    addNewVilla();
                    break;
                case 2:
                    addAvailableVilla();
                    break;
                case 3:
                    new FacilityServiceImpl().displayAddNewService();
                    break;
                default:
                    System.out.println("Wrong choice");
            }
        }
    }

    @Override
    public void addAvailableVilla() {
        System.out.println("Here is the list of Villa. Which Villa you wanna add?");
        for (Facility facility : facilityMap.keySet()) {
            if (facility instanceof Villa) {
                System.out.println(facility.getName());
            }
        }
        System.out.println("Input your choice");
        String name = input().nextLine();
        for (Facility facility : facilityMap.keySet()) {
            if (facility.getName().equals(name)) {
                if (facilityMap.get(facility) >= 5) {
                    System.out.println("Out of service");
                    break;
                }
                facilityMap.put(facility, facilityMap.get(facility) + 1);
                System.out.println("Success");
            }
        }
    }

<<<<<<< HEAD
=======
    //name,area,price,capacity,gueststay,standard,swimmingpool
>>>>>>> e84db6c9c9dc6c1c095e1f67df68f1b60ddb3f28
    @Override
    public void addNewVilla() {
        System.out.println("Name: ");
        String name = input().nextLine();
        System.out.println("Area");
        double area = input().nextDouble();
        System.out.println("Price");
        double price = input().nextDouble();
        System.out.println("Capacity");
        int capacity = input().nextInt();
        System.out.println("Guest Stay");
        String guestStay = input().nextLine();
        System.out.println("Standard");
        String standard = input().nextLine();
        System.out.println("Swimming pool area");
        double swimmingPoolArea = input().nextDouble();
        System.out.println("Floor");
        int floor = input().nextInt();
        System.out.println("Success");
        String line = name + "," + area + "," + price + "," + capacity + "," + guestStay + "," + standard
                + "," + swimmingPoolArea + "," + floor + "," + 0;
        new ReadAndWriteFile<>().writeFile(FILE_PATH_VILLA, line, true);
<<<<<<< HEAD
=======
        facilityMap.clear();
>>>>>>> e84db6c9c9dc6c1c095e1f67df68f1b60ddb3f28
    }

    @Override
    public void displayAddNewHouse() {
        while (true) {
            System.out.println("---You have 2 choices---");
            System.out.println("1. Add a whole new House");
            System.out.println("2. Use available House");
            System.out.println("3. Back to menu");
            System.out.println("Your choice:");
            int choice = input().nextInt();
            switch (choice) {
                case 1:
                    addNewHouse();
                    break;
                case 2:
                    addAvailableHouse();
                    break;
                case 3:
                    new FacilityServiceImpl().displayAddNewService();
                    break;
                default:
                    System.out.println("Wrong choice");
            }
        }
    }

    @Override
    public void addNewHouse() {
        System.out.println("Name: ");
        String name = input().nextLine();
        System.out.println("Area");
        double area = input().nextDouble();
        System.out.println("Price");
        double price = input().nextDouble();
        System.out.println("Capacity");
        int capacity = input().nextInt();
        System.out.println("Guest Stay");
        String guestStay = input().nextLine();
        System.out.println("Standard");
        String standard = input().nextLine();
        System.out.println("Floor");
        int floor = input().nextInt();
        System.out.println("Success");
        String line = name + "," + area + "," + price + "," + capacity + "," + guestStay + "," + standard
                + "," + floor + "," + 0;
        new ReadAndWriteFile<>().writeFile(FILE_PATH_HOUSE, line, true);
<<<<<<< HEAD
=======
        facilityMap.clear();
>>>>>>> e84db6c9c9dc6c1c095e1f67df68f1b60ddb3f28
    }

    @Override
    public void addAvailableHouse() {
        System.out.println("Here is the list of House. Which House you wanna add?");
        for (Facility facility : facilityMap.keySet()) {
            if (facility instanceof House) {
                System.out.println(facility.getName());
            }
        }
        System.out.println("Input your choice");
        String name = input().nextLine();
        for (Facility facility : facilityMap.keySet()) {
            if (facility.getName().equals(name)) {
                if (facilityMap.get(facility) >= 5) {
                    System.out.println("Out of service");
                    break;
                }
                facilityMap.put(facility, facilityMap.get(facility) + 1);
                System.out.println("Success");
            }
        }
    }

    @Override
    public void displayAddNewRoom() {
        while (true) {
            System.out.println("---You have 2 choices---");
            System.out.println("1. Add a whole new Room");
            System.out.println("2. Use available Room");
            System.out.println("3. Back to menu");
            System.out.println("Your choice:");
            int choice = input().nextInt();
            switch (choice) {
                case 1:
                    addNewRoom();
                    break;
                case 2:
                    addAvailableRoom();
                    break;
                case 3:
                    new FacilityServiceImpl().displayAddNewService();
                    break;
                default:
                    System.out.println("Wrong choice");
            }
        }
    }

    @Override
    public void addNewRoom() {
        System.out.println("Name: ");
        String name = input().nextLine();
        System.out.println("Area");
        double area = input().nextDouble();
        System.out.println("Price");
        double price = input().nextDouble();
        System.out.println("Capacity");
        int capacity = input().nextInt();
        System.out.println("Guest Stay");
        String guestStay = input().nextLine();
        System.out.println("Free Service");
        String freeService = input().nextLine();
        System.out.println("Success");
        String line = name + "," + area + "," + price + "," + capacity + "," + guestStay + ","
                + freeService + "," + 0;
        new ReadAndWriteFile<>().writeFile(FILE_PATH_ROOM, line, true);
<<<<<<< HEAD
=======
        facilityMap.clear();
>>>>>>> e84db6c9c9dc6c1c095e1f67df68f1b60ddb3f28
    }

    @Override
    public void addAvailableRoom() {
        System.out.println("Here is the list of Room. Which House you wanna add?");
        for (Facility facility : facilityMap.keySet()) {
            if (facility instanceof Room) {
                System.out.println(facility.getName());
            }
        }
        System.out.println("Input your choice");
        String name = input().nextLine();
        for (Facility facility : facilityMap.keySet()) {
            if (facility.getName().equals(name)) {
                if (facilityMap.get(facility) >= 5) {
                    System.out.println("Out of service");
                    break;
                }
                facilityMap.put(facility, facilityMap.get(facility) + 1);
                System.out.println("Success");
            }
        }
    }

    @Override
    public void displayMaintenanceList() {
        readFacilityFromFile();
        for (Map.Entry<Facility, Integer> maintenanceFacilityList : facilityMap.entrySet()) {
            if (maintenanceFacilityList.getValue() >= 5) {
                System.out.println(maintenanceFacilityList);
            }
        }
        facilityMap.clear();
    }

}
