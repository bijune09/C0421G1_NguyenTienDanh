package TestMySelf.service.customer;

import TestMySelf.Person.Customer;
import TestMySelf.lib.MyCheckRegex;
import TestMySelf.lib.RegexFinal;
import TestMySelf.service.Service;
import TestMySelf.utils.ReadAndWrite;

import java.util.LinkedList;
import java.util.List;

public class CustomerServiceImpl extends ReadAndWrite implements Service {
    private boolean check = false;
    public static List<Customer> customerList = new LinkedList<>();
    private final String FILE_PATH_CUSTOMER =
            "D:\\C0421G1_NguyenTienDanh\\Module_2\\src\\TestMySelf\\data\\customer.csv";

    public List<Customer> readFileFromCSV() {
        List<Customer> arrayFromFile = new LinkedList<>();
        List<String> lines = readFile(FILE_PATH_CUSTOMER);
        for (String line : lines) {
            String[] splitLine = line.split(",");
            Customer customer = new Customer(Integer.parseInt(splitLine[0]), splitLine[1], splitLine[2],
                    splitLine[3], splitLine[4], splitLine[5], splitLine[6], splitLine[7], splitLine[8]);
            arrayFromFile.add(customer);
        }
        return arrayFromFile;
    }

    @Override
    public void display() {
        customerList = readFileFromCSV();
        if (customerList.isEmpty()) {
            System.out.println("Nothing");
        } else {
            for (Customer customer : customerList) {
                System.out.println(customer);
            }
        }
    }

    @Override
    public void add() {
        customerList = readFileFromCSV();
        int id;
        if (customerList.isEmpty()) {
            id = 1;
        } else {
            id = customerList.get(customerList.size() - 1).getId() + 1;
        }
        System.out.println("Input Name:");
        String name = new MyCheckRegex().checkLoop(RegexFinal.REGEX_NAME, input().nextLine());
        System.out.println("Input Date of Birth");
        String dateOfBirth = new MyCheckRegex().checkLoop(RegexFinal.REGEX_DAY_OF_BIRTH, input().nextLine());
        System.out.println("Input Gender");
        String gender = new MyCheckRegex().checkLoop(RegexFinal.REGEX_GENDER, input().nextLine());
        System.out.println("Input Identity Number");
        String identityNumber = new MyCheckRegex().checkLoop(RegexFinal.REGEX_IDENTITY_NUMBER, input().nextLine());
        System.out.println("Input Phone Number");
        String phoneNumber = new MyCheckRegex().checkLoop(RegexFinal.REGEX_PHONE_NUMBER, input().nextLine());
        System.out.println("Input Email");
        String email = new MyCheckRegex().checkLoop(RegexFinal.REGEX_EMAIL, input().nextLine());
        System.out.println("Input Type of Guest");
        String typeOfGuest = new MyCheckRegex().checkLoop(RegexFinal.REGEX_TYPE_GUEST, input().nextLine());
        System.out.println("Input Address");
        String address = new MyCheckRegex().checkLoop(RegexFinal.REGEX_ADDRESS, input().nextLine());
        String newCustomer = id + "," + name + "," + dateOfBirth + "," + gender + "," + identityNumber +
                "," + phoneNumber + "," + email + "," + typeOfGuest + "," + address;
        writeFile(FILE_PATH_CUSTOMER, newCustomer, true);
        System.out.println("Success!!");
    }

    @Override
    public void edit() {
        customerList = readFileFromCSV();
        System.out.println("Input ID you wanna edit");
        int findID = new MyCheckRegex().choiceNumberException();
        for (Customer customer : customerList) {
            if (customer.getId() == findID) {
                System.out.println("---------------");
                System.out.println("ID has been founded. Edit information");
                System.out.println("New Name:");
                customer.setName(new MyCheckRegex().checkLoop(RegexFinal.REGEX_NAME, input().nextLine()));
                System.out.println("New Date Of Birth:");
                customer.setDateOfBirth(new MyCheckRegex().checkLoop(RegexFinal.REGEX_DAY_OF_BIRTH, input().nextLine()));
                System.out.println("New Gender:");
                customer.setGender(new MyCheckRegex().checkLoop(RegexFinal.REGEX_GENDER, input().nextLine()));
                System.out.println("New Identity Number:");
                customer.setIdentityNumber
                        (new MyCheckRegex().checkLoop(RegexFinal.REGEX_IDENTITY_NUMBER, input().nextLine()));
                System.out.println("New Phone Number:");
                customer.setPhoneNumber(new MyCheckRegex().checkLoop(RegexFinal.REGEX_PHONE_NUMBER, input().nextLine()));
                System.out.println("New Email:");
                customer.setEmail(new MyCheckRegex().checkLoop(RegexFinal.REGEX_EMAIL, input().nextLine()));
                System.out.println("New Type Of Guest:");
                customer.setTypeOfGuest(new MyCheckRegex().checkLoop(RegexFinal.REGEX_TYPE_GUEST, input().nextLine()));
                System.out.println("New Address:");
                customer.setAddress(new MyCheckRegex().checkLoop(RegexFinal.REGEX_ADDRESS, input().nextLine()));
                System.out.println("Success!!");
                break;
            }
        }
        if (check) {
            System.out.println("Sorry!! Your id is'nt available");
        }
        deleteContentFromCSV(FILE_PATH_CUSTOMER);
        writeCustomerList();
    }

    public void writeCustomerList() {
        String writeCustomer;
        for (Customer customer : customerList) {
            writeCustomer = customer.getId() + "," + customer.getName() + "," + customer.getDateOfBirth() + "," +
                    customer.getGender() + "," + customer.getIdentityNumber() + "," + customer.getPhoneNumber() + ","
                    + customer.getEmail() + "," + customer.getTypeOfGuest() + "," + customer.getAddress();
            writeFile(FILE_PATH_CUSTOMER, writeCustomer, true);
        }
    }

    @Override
    public void delete() {
        customerList = readFileFromCSV();
        System.out.println("Input ID you wanna delete:");
        int deleteID = input().nextInt();
        for (Customer customer : customerList) {
            if (customer.getId() == deleteID) {
                customerList.remove(customer);
            }
        }
        deleteContentFromCSV(FILE_PATH_CUSTOMER);
        writeCustomerList();
    }
}
