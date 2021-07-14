package case_study.services.customer;

import case_study.models.person.Customer;
import case_study.utils.read_and_write_file.ReadAndWriteFile;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl extends ReadAndWriteFile implements CustomerService {
    public static Scanner input() {
<<<<<<< HEAD
        Scanner scanner = new Scanner(System.in);
        return scanner;
=======
        Scanner sc = new Scanner(System.in);
        return sc;
>>>>>>> e84db6c9c9dc6c1c095e1f67df68f1b60ddb3f28
    }

    static boolean check = false;
    private final String FILE_PATH =
<<<<<<< HEAD
            "D:\\C0421G1_NguyenTienDanh\\Module_2\\src\\case_study\\data\\customer.csv";
=======
            "D:\\C0421G1_NguyenTienDanh_New\\C0421G1_NguyenTienDanh\\Module_2\\src\\case_study\\data\\customer.csv";
>>>>>>> e84db6c9c9dc6c1c095e1f67df68f1b60ddb3f28
    public static List<Customer> customers = new LinkedList<>();

    @Override
    public void readCustomerFromFile() {
        List<String> StringList = readFile(FILE_PATH);
        for (String string : StringList) {
            String[] splitString = string.split(",");
            Customer customer = new Customer(Integer.parseInt(splitString[0]), splitString[1], splitString[2],
                    splitString[3], splitString[4], splitString[5], splitString[6], splitString[7], splitString[8]);
            customers.add(customer);
        }
    }

    @Override
    public void addNewCustomerWhenEdit() {
<<<<<<< HEAD
        String newCustomer;
=======
        String newCustomer = null;
>>>>>>> e84db6c9c9dc6c1c095e1f67df68f1b60ddb3f28
        for (Customer customer : customers) {
            newCustomer = customer.getId() + "," + customer.getName() + "," + customer.getDateOfBirth() + "," +
                    customer.getGender() + "," + customer.getIdentityNumber() + "," + customer.getPhoneNumber() + ","
                    + customer.getEmail() + "," + customer.getTypeOfCustomer() + "," + customer.getAddress();
            writeFile(FILE_PATH, newCustomer, true);
        }
    }

    @Override
    public void add() {
        readCustomerFromFile();
<<<<<<< HEAD
        int id;
=======
        int id = 0;
>>>>>>> e84db6c9c9dc6c1c095e1f67df68f1b60ddb3f28
        if (customers.isEmpty()) {
            id = 1;
        } else {
            id = customers.get(customers.size() - 1).getId() + 1;
        }
        System.out.println("Name: ");
        String name = input().nextLine();
        System.out.println("Date of birth: ");
        String dob = input().nextLine();
        System.out.println("Gender: ");
        String gender = input().nextLine();
        System.out.println("Identity number: ");
        String identityNumber = input().nextLine();
        System.out.println("Phone Number: ");
        String phoneNumber = input().nextLine();
        System.out.println("Email: ");
        String email = input().nextLine();
        System.out.println("Type of customer: ");
        String typeOfCustomer = input().nextLine();
        System.out.println("Address: ");
        String address = input().nextLine();
        String line = id + "," + name + "," + dob + "," + gender + "," + identityNumber + "," +
                phoneNumber + "," + email + "," + typeOfCustomer + "," + address;
        writeFile(FILE_PATH, line, true);
        System.out.println("Customer has been added");
        customers.clear();
    }

    @Override
    public void remove() {

    }

    @Override
    public void edit() {
        readCustomerFromFile();
        System.out.println("Input id:");
<<<<<<< HEAD
        int id = 0;
        boolean checkValid = false;
        while (!checkValid) {
            try {
                id = input().nextInt();
                checkValid = true;
            } catch (NumberFormatException exception) {
                System.out.println("YOU MUST INPUT NUMBER!!!");
            }
        }
=======
        int id = input().nextInt();
>>>>>>> e84db6c9c9dc6c1c095e1f67df68f1b60ddb3f28
        for (Customer out : customers) {
            if (out.getId() == id) {
                System.out.println("Name:");
                String newName = input().nextLine();
                System.out.println("Date of birth:");
                String newDob = input().nextLine();
                System.out.println("Gender");
                String newGender = input().nextLine();
                System.out.println("Identity Number:");
                String newIdentityNumber = input().nextLine();
                System.out.println("Phone number:");
                String newPhoneNumber = input().nextLine();
                System.out.println("Email: ");
                String newEmail = input().nextLine();
                System.out.println("Type of customer: ");
                String newTypeOfCustomer = input().nextLine();
                System.out.println("Address: ");
                String newAddress = input().nextLine();
                out.setName(newName);
                out.setDateOfBirth(newDob);
                out.setGender(newGender);
                out.setIdentityNumber(newIdentityNumber);
                out.setPhoneNumber(newPhoneNumber);
                out.setEmail(newEmail);
                out.setTypeOfCustomer(newTypeOfCustomer);
                out.setAddress(newAddress);
                deleteContentFromCSV(FILE_PATH);
                addNewCustomerWhenEdit();
                check = true;
                System.out.println("Success");
            }
        }
<<<<<<< HEAD
        if (!check) {
=======
        if (check == false) {
>>>>>>> e84db6c9c9dc6c1c095e1f67df68f1b60ddb3f28
            System.out.println("Invalid id");
        }
        customers.clear();
    }

    @Override
    public void display() {
        readCustomerFromFile();
        if (customers.isEmpty()) {
            System.out.println("Nothing");
        } else {
            for (Customer customer : customers) {
                System.out.println(customer);
            }
        }
        customers.clear();
    }

<<<<<<< HEAD
=======

>>>>>>> e84db6c9c9dc6c1c095e1f67df68f1b60ddb3f28
}
