package case_study.services.employee;


import case_study.models.person.Employee;
import case_study.utils.read_and_write_file.ReadAndWriteFile;
import case_study.utils.read_and_write_file_object.ReadAndWriteFileObject;
import org.junit.platform.commons.util.StringUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl extends ReadAndWriteFile implements EmployeeService {
    public static Scanner input() {
        Scanner sc = new Scanner(System.in);
        return sc;
    }


    static boolean check = false;
    private static List<Employee> employees = new ArrayList<>();
    private static final String FILE_PATH
            = "D:\\C0421G1_NguyenTienDanh_New\\C0421G1_NguyenTienDanh\\Module_2\\src\\case_study\\data\\employee.csv";

    public void readEmployeeFromFile() {
        List<String> stringList = readFile(FILE_PATH);
        for (String string : stringList) {
            String[] splitString = string.split(",");
            Employee newEmployee = new Employee(Integer.parseInt(splitString[0]),
                    splitString[1],
                    splitString[2],
                    splitString[3],
                    splitString[4],
                    splitString[5],
                    splitString[6],
                    splitString[7],
                    splitString[8],
                    Double.parseDouble(splitString[9]));
            employees.add(newEmployee);
        }
    }

    @Override
    public void add() {
        readEmployeeFromFile();
        int id = 0;
        if (employees.isEmpty()) {
            id = 1;
        } else {
            id = employees.get(employees.size() - 1).getId() + 1;
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
        System.out.println("Education: ");
        String education = input().nextLine();
        System.out.println("Position: ");
        String position = input().nextLine();
        System.out.println("Salary: ");
        double salary = input().nextDouble();
        String newEmployee = id + "," + name + "," + dob + "," + gender + "," + identityNumber + "," + phoneNumber +
                "," + email + "," + education + "," + position + "," + salary;
        writeFile(FILE_PATH, newEmployee, true);
        System.out.println("Employee has been added");
        employees.clear();
    }

    @Override
    public void remove() {
        System.out.println("Input Id: ");
        int id = input().nextInt();
        for (Employee out : employees) {
            if (out.getId() == id) {
                employees.remove(out);
                check = true;
                break;
            }
        }
        if (check) {
            System.out.println("Invalid id");
        }
    }

    @Override
    public void edit() {
        readEmployeeFromFile();
        System.out.println("Input id:");
        int id = input().nextInt();
        for (Employee out : employees) {
            if (out.getId() == id) {
                System.out.println("New Name:");
                String newName = input().nextLine();
                System.out.println("New Date of birth:");
                String newDob = input().nextLine();
                System.out.println("New Gender");
                String newGender = input().nextLine();
                System.out.println("New Identity Number:");
                String newIdentityNumber = input().nextLine();
                System.out.println("New Phone number:");
                String newPhoneNumber = input().nextLine();
                System.out.println("New Email: ");
                String newEmail = input().nextLine();
                System.out.println("New Education: ");
                String newEducation = input().nextLine();
                System.out.println("New Position: ");
                String newPosition = input().nextLine();
                System.out.println("New Salary: ");
                double newSalary = input().nextDouble();
                out.setName(newName);
                out.setDateOfBirth(newDob);
                out.setGender(newGender);
                out.setIdentityNumber(newIdentityNumber);
                out.setPhoneNumber(newPhoneNumber);
                out.setEmail(newEmail);
                out.setEducation(newEducation);
                out.setPosition(newPosition);
                out.setSalary(newSalary);
                check = true;
                deleteContentFromCSV(FILE_PATH);
                addNewWhenEdit();
                break;
            }
        }
        if (check == false) {
            System.out.println("Invalid id");
        }
        employees.clear();
    }

    @Override
    public void display() {
        readEmployeeFromFile();
        if (employees.isEmpty()) {
            System.out.println("Nothing");
        } else {
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        }
        employees.clear();
    }

    @Override
    public void addNewWhenEdit() {
        String arrayEmployee = null;
        for (Employee employee : employees){
            arrayEmployee = employee.getId()+","+employee.getName()+","+employee.getDateOfBirth()+","+employee.getGender()
                    +","+employee.getIdentityNumber()+","+employee.getPhoneNumber()+","+employee.getEmail()+
                    ","+employee.getEducation() +","+employee.getPosition()+","+employee.getSalary();
            writeFile(FILE_PATH,arrayEmployee,true);
        }
    }
}
