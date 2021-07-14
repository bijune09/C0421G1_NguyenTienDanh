package case_study.services.booking_and_contract;

import case_study.models.booking.Booking;
import case_study.models.facility.Facility;
import case_study.models.facility.House;
import case_study.models.facility.Room;
import case_study.models.facility.Villa;
import case_study.models.person.Customer;
import case_study.utils.read_and_write_file.ReadAndWriteFile;
import sun.awt.image.ImageWatched;

import java.awt.print.Book;
import java.util.*;

public class BookingServiceImpl extends ReadAndWriteFile implements BookingService {
    private static final String FILE_PATH_CUSTOMER
<<<<<<< HEAD
            = "D:\\C0421G1_NguyenTienDanh\\Module_2\\src\\case_study\\data\\customer.csv";
    private static final String FILE_PATH_BOOKING
            = "D:\\C0421G1_NguyenTienDanh\\Module_2\\src\\case_study\\data\\booking.csv";
    private static final String FILE_PATH_VILLA
            = "D:\\C0421G1_NguyenTienDanh\\Module_2\\src\\case_study\\data\\villa.csv";
    private static final String FILE_PATH_HOUSE
            = "D:\\C0421G1_NguyenTienDanh\\Module_2\\src\\case_study\\data\\house.csv";
    private static final String FILE_PATH_ROOM
            = "D:\\C0421G1_NguyenTienDanh\\Module_2\\src\\case_study\\data\\room.csv";
=======
            = "D:\\C0421G1_NguyenTienDanh_New\\C0421G1_NguyenTienDanh\\Module_2\\src\\case_study\\data\\customer.csv";

    private static final String FILE_PATH_BOOKING
            = "D:\\C0421G1_NguyenTienDanh_New\\C0421G1_NguyenTienDanh\\Module_2\\src\\case_study\\data\\booking.csv";

    private static final String FILE_PATH_CONTRACT
            = "D:\\C0421G1_NguyenTienDanh_New\\C0421G1_NguyenTienDanh\\Module_2\\src\\case_study\\data\\contract.csv";

    private static final String FILE_PATH_VILLA
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

<<<<<<< HEAD
    static boolean check = false;

    public static Set<Booking> bookings = new TreeSet<>();

    @Override
    public void readBookingFromFile() {
        List<String> lines = readFile(FILE_PATH_BOOKING);
        for (String line : lines) {
            String[] splitLine = line.split(",");
            Booking booking = new Booking(Integer.parseInt(splitLine[0]), splitLine[1], splitLine[2],
                    Integer.parseInt(splitLine[3]), splitLine[4], splitLine[5]);
            bookings.add(booking);
        }
=======
    public static Set<Booking> bookings = new TreeSet<>();

    static {
        bookings.add(new Booking(1, "12/01/2021", "15/01/2021", 2, "Karaoke tay vịn", "***"));
        bookings.add(new Booking(2, "12/01/2021", "12/01/2021", 2, "Limousine Car", "***"));
        bookings.add(new Booking(3, "16/01/2021", "16/01/2021", 5, "Bicycle", "**"));
        bookings.add(new Booking(4, "17/01/2021", "18/01/2021", 4, "Board", "****"));
>>>>>>> e84db6c9c9dc6c1c095e1f67df68f1b60ddb3f28
    }

    public static Queue<Booking> bookingQueue = new LinkedList<>();

    static {
        bookingQueue.addAll(bookings);
    }

    public static List<Customer> customers = new LinkedList<>();

    private void displayCustomerFromFile() {
        List<String> lines = readFile(FILE_PATH_CUSTOMER);
        for (String line : lines) {
            String[] splitLine = line.split(",");
            Customer customer = new Customer(Integer.parseInt(splitLine[0]), splitLine[1], splitLine[2], splitLine[3],
                    splitLine[4], splitLine[5], splitLine[6], splitLine[7], splitLine[8]);
            customers.add(customer);
        }
    }

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

<<<<<<< HEAD

    private void checkFacility(String name) {
        for (Facility facility : facilityMap.keySet()) {
            if (facility.getName().equals(name)) {
                if (facilityMap.get(facility) >= 5) {
                    System.out.println("Out of service");
                    break;
                }
                facilityMap.put(facility, facilityMap.get(facility) + 1);
                break;
            }
        }
        deleteContentFromCSV(FILE_PATH_HOUSE);
        deleteContentFromCSV(FILE_PATH_VILLA);
        deleteContentFromCSV(FILE_PATH_ROOM);
        for (Facility facility : facilityMap.keySet()) {
            if (facility instanceof House) {
                String line = facility.getName() + "," + facility.getArea() + "," + facility.getPrice() + ","
                        + facility.getCapacity() + "," + facility.getGuestStay() + "," + ((House) facility).getStandard()
                        + "," + ((House) facility).getFloor() + "," + facilityMap.get(facility);
                writeFile(FILE_PATH_HOUSE, line, true);
            }
            if (facility instanceof Villa) {
                String line = facility.getName() + "," + facility.getArea() + "," + facility.getPrice() + ","
                        + facility.getCapacity() + "," + facility.getGuestStay() + "," + ((Villa) facility).getStandard()
                        + "," + ((Villa) facility).getSwimmingPoolArea() + "," + ((Villa) facility).getFloor() + ","
                        + facilityMap.get(facility);
                writeFile(FILE_PATH_VILLA, line, true);
            }
            if (facility instanceof Room) {
                String line = facility.getName() + "," + facility.getArea() + "," + facility.getPrice() + ","
                        + facility.getCapacity() + "," + facility.getGuestStay() + "," + ((Room) facility).getFreeService()
                        + "," + facilityMap.get(facility);
                writeFile(FILE_PATH_ROOM, line, true);
            }
        }
    }

=======
>>>>>>> e84db6c9c9dc6c1c095e1f67df68f1b60ddb3f28
    @Override
    public void add() {
        readFacilityFromFile();
        displayCustomerFromFile();
        System.out.println("ID List of Customer: ");
        for (Customer customer : customers) {
<<<<<<< HEAD
            System.out.println("ID :" + customer.getId() + ", Name: " + customer.getName());
=======
            System.out.println("ID :"+customer.getId()+", Name: "+customer.getName());
>>>>>>> e84db6c9c9dc6c1c095e1f67df68f1b60ddb3f28
        }
        System.out.println("--------");
        System.out.println("List of Service: ");
        for (Facility facility : facilityMap.keySet()) {
            System.out.println(facility.getName());
        }
        System.out.println("--------");
<<<<<<< HEAD
        System.out.println("ID booking:");
=======

        System.out.println("ID Booking");
>>>>>>> e84db6c9c9dc6c1c095e1f67df68f1b60ddb3f28
        int idBooking = input().nextInt();
        //check facility
        System.out.println("Service Name");
        String nameOfService = input().nextLine();
        checkFacility(nameOfService);
        //
        System.out.println("Start Day");
        String first = input().nextLine();
        System.out.println("End Day");
        String last = input().nextLine();
        System.out.println("ID Customer");
        int idCustomer = input().nextInt();
        System.out.println("Type Of Service");
        String typeOfService = input().nextLine();
<<<<<<< HEAD
        String line = idBooking + "," + first + "," + last + "," + idCustomer + "," + nameOfService
                + "," + typeOfService;
        writeFile(FILE_PATH_BOOKING, line, true);
=======
        Booking newBooking = new Booking(idBooking, first, last, idCustomer, nameOfService, typeOfService);
        bookings.add(newBooking);
>>>>>>> e84db6c9c9dc6c1c095e1f67df68f1b60ddb3f28
        System.out.println("Booking Success");
        customers.clear();
        facilityMap.clear();
    }

    @Override
    public void remove() {

    }

    @Override
    public void edit() {

    }

    @Override
    public void display() {
        readBookingFromFile();
        Iterator iterator = bookings.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        bookings.clear();
    }
}
