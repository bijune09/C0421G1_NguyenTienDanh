package case_study.services.booking_and_contract;

import case_study.models.booking.Booking;
import case_study.models.booking.Contract;
import case_study.utils.read_and_write_file.ReadAndWriteFile;

import java.util.*;

public class ContractServiceImpl extends ReadAndWriteFile implements ContractService {
    public static Scanner input() {
        Scanner sc = new Scanner(System.in);
        return sc;
    }

    private static final String FILE_PATH_BOOKING
            = "D:\\C0421G1_NguyenTienDanh_New\\C0421G1_NguyenTienDanh\\Module_2\\src\\case_study\\data\\booking.csv";

    private static final String FILE_PATH_CONTRACT
            = "D:\\C0421G1_NguyenTienDanh_New\\C0421G1_NguyenTienDanh\\Module_2\\src\\case_study\\data\\contract.csv";

    public static Queue<Booking> bookingQueue = new PriorityQueue<>();
    public static Set<Booking> bookings = new TreeSet<>();
    public static List<Contract> contracts = new ArrayList<>();

    public Set<Booking> readBookingFromFile() {
        List<String> lines = readFile(FILE_PATH_BOOKING);
        for (String line : lines) {
            String[] splitLine = line.split(",");
            Booking booking = new Booking(Integer.parseInt(splitLine[0]), splitLine[1], splitLine[2],
                    Integer.parseInt(splitLine[3]), splitLine[4], splitLine[5]);
            bookings.add(booking);
        }
        return bookings;
    }

    public List<Contract> readContractFromFile() {
        List<String> lines = readFile(FILE_PATH_CONTRACT);
        for (String line : lines) {
            String[] splitLine = line.split(",");
            Contract contract = new Contract(Integer.parseInt(splitLine[0]), Integer.parseInt(splitLine[1]),
                    Double.parseDouble(splitLine[2]), Double.parseDouble(splitLine[3]), Integer.parseInt(splitLine[4]));
            contracts.add(contract);
        }
        return contracts;
    }

    @Override
    public void add() {
        bookings = readBookingFromFile();
        bookingQueue.addAll(bookings);
        while (!bookingQueue.isEmpty()) {
            System.out.println("----------------");
            Booking newContract = bookingQueue.poll();
            System.out.println("ID Customer: " + newContract.getIdCustomer());
            int idCustomer = newContract.getIdCustomer();
            System.out.println("ID Booking:" + newContract.getIdBooking());
            int idBooking = newContract.getIdBooking();
            System.out.println("ID Contract: ");
            int idContract = input().nextInt();
            System.out.println("Input Deposit: ");
            double deposit = input().nextDouble();
            System.out.println("Amount paid: ");
            double amountPaid = input().nextDouble();
            String line = idContract + "," + idBooking + "," + deposit + "," + amountPaid + "," + idCustomer;
            writeFile(FILE_PATH_CONTRACT, line, true);
            System.out.println("---------------");
        }
        deleteContentFromCSV(FILE_PATH_BOOKING);
    }

    @Override
    public void remove() {

    }

    public void addNewContractWhenEdit() {
        String newContract;
        for (Contract contract : contracts) {
            newContract = contract.getIdContract() + "," + contract.getIdBooking() + "," + contract.getDeposit()
                    + "," +contract.getAmountPaid( ) + "," +contract.getIdCustomer();
            writeFile(FILE_PATH_CONTRACT,newContract,true);
        }
    }

    @Override
    public void edit() {
        contracts = readContractFromFile();
        System.out.println("Please input ID Contract");
        int findID = 0;
        int choice =0;
        boolean checkValid = false;
        while(!checkValid){
            try {
                findID = input().nextInt();
                checkValid = true;
            } catch (NumberFormatException exception){
                System.out.println("YOU MUST INPUT NUMBER!!!");
            }
        }
        for (Contract contract : contracts) {
            if (contract.getIdContract() == findID) {
                System.out.println("ID Booking");
                int newIdBooking = input().nextInt();
                System.out.println("Deposit");
                double newDeposit = input().nextDouble();
                System.out.println("Amount has been paid");
                double newAmountPaid = input().nextDouble();
                System.out.println("ID Customer");
                int newIdCustomer = input().nextInt();
                contract.setIdBooking(newIdBooking);
                contract.setDeposit(newDeposit);
                contract.setAmountPaid(newAmountPaid);
                contract.setIdCustomer(newIdCustomer);
                deleteContentFromCSV(FILE_PATH_CONTRACT);
                addNewContractWhenEdit();
                System.out.println("Success!!");
                break;
            }
        }
        contracts.clear();
    }

    @Override
    public void display() {
        contracts = readContractFromFile();
        for (Contract contract : contracts) {
            System.out.println(contract);
        }
        contracts.clear();
    }
}
