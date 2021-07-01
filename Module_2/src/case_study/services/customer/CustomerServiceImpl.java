package case_study.services.customer;

import case_study.models.person.Customer;
import case_study.services.read_and_write_file.ReadAndWriteFile;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService {
    public static Scanner input(){
        Scanner sc = new Scanner(System.in);
        return sc;
    }

    static boolean check = false;
    public final String FILE_PATH = "D:\\C0421G1_NguyenTienDanh\\Module_2\\src\\case_study\\data\\customer.csv";
    public static List<Customer> customers = new LinkedList<>();
    static {
        customers.add(new Customer(1,"Khach hang a","12/12/1998","Male","201098123","0984271641","khachhangA@gmail.com","Diamond","192 nguyen luong bang"));
        customers.add(new Customer(2,"Khach hang b","02/08/1996","Female","201829249","0926481726","khachhangB@gmail.com","Platinum","180 cao thang"));
        customers.add(new Customer(3,"Khach hang c","10/01/1995","Male","201249248","0914234812","khachhangC@gmail.com","Gold","172 le duan"));
        customers.add(new Customer(4,"Khach hang d","01/07/1992","Female","201180923","0934191204","khachhangD@gmail.com","Silver","80 tran xuan le"));
    }

    @Override
    public void add() {
        System.out.println("Id: ");
        int id = input().nextInt();
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
        Customer newCustomer = new Customer(id,name,dob,gender,identityNumber,phoneNumber,email,typeOfCustomer,address);
        customers.add(newCustomer);
        String line = id + "," + name +
                "," + gender + "," + identityNumber + "," +
                phoneNumber + "," + email + "," +typeOfCustomer+
                ","+address;
        new ReadAndWriteFile().writeFile(FILE_PATH,line);
        System.out.println("Customer has been added");
    }

    @Override
    public void remove() {

    }

    @Override
    public void edit() {
        System.out.println("Input id:");
        int id = input().nextInt();
        for (Customer out : customers){
            if (out.getId()==id){
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
                check = true;
            }
        }
        if (check){
            System.out.println("Invalid id");
        }
    }

    @Override
    public void display() {
        if (customers.isEmpty()){
            System.out.println("Nothing");
        } else {
            for (Customer customer: customers){
                System.out.println(customer);
            }
        }
    }
}
