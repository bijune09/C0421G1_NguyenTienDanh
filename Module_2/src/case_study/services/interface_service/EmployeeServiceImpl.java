package case_study.services.interface_service;

import case_study.models.person.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements EmployeeService{
    public static Scanner input(){
        Scanner sc = new Scanner(System.in);
        return sc;
    }

    static boolean check = false;
    public static List<Employee> employees = new ArrayList<>();
    static {
        employees.add(new Employee(1,"Nguyen Van A","12/12/1990","Male","2221638403","0932545644","vana@gmail.com","TrungCap","Lễ tân",250000));
        employees.add(new Employee(2,"Nguyen Van B","21/10/1998","Female","2229384018","0906301810","vanB@gmail.com","DaiHoc","Phục vụ",200000));
        employees.add(new Employee(3,"Nguyen Van C","04/05/1995","Male","2224029184","01214525325","vanC@gmail.com","CaoDang","Giám sát",500000));
        employees.add(new Employee(4,"Nguyen Van D","03/07/1997","Female","2221920485","0923814619","vanD@gmail.com","DaiHoc","Quản lý",500000));
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
        System.out.println("Education: ");
        String education = input().nextLine();
        System.out.println("Position: ");
        String position = input().nextLine();
        System.out.println("Salary: ");
        double salary = input().nextDouble();
        employees.add(new Employee(id,name,dob,gender,identityNumber,phoneNumber,email,education,position,salary));
        System.out.println("Employee has been added");
    }

    @Override
    public void remove() {
        System.out.println("Input Id: ");
        int id = input().nextInt();
        for (Employee out : employees){
            if (out.getId()==id){
                employees.remove(out);
                check = true;
                break;
            }
        }
        if (check){
            System.out.println("Invalid id");
        }
    }

    @Override
    public void edit() {
        System.out.println("Input id:");
        int id = input().nextInt();
        for (Employee out : employees){
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
                System.out.println("Education: ");
                String newEducation = input().nextLine();
                System.out.println("Position: ");
                String newPosition = input().nextLine();
                System.out.println("Salary: ");
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
            }
        }
        if (check){
            System.out.println("Invalid id");
        }
    }

    @Override
    public void display() {
        if (employees.isEmpty()){
            System.out.println("Nothing");
        } else {
            for (Employee employee: employees){
                System.out.println(employee);
            }
        }
    }
}
