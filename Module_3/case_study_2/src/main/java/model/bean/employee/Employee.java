package model.bean.employee;

import java.util.Date;

public class Employee {
    private int employee_id;
    private String employee_name;
    private int employee_id_position;
    private int employee_id_education;
    private int employee_id_division;
    private String employee_birthday;
    private String employee_id_card;
    private double employee_salary;
    private String employee_phone;
    private String employee_email;
    private String employee_address;
    private String employee_user_name;

    public Employee() {
    }

    public Employee(String employee_name, int employee_id_position, int employee_id_education, int employee_id_division,
                    String employee_birthday, String employee_id_card, double employee_salary, String employee_phone,
                    String employee_email, String employee_address, String employee_user_name) {
        this.employee_name = employee_name;
        this.employee_id_position = employee_id_position;
        this.employee_id_education = employee_id_education;
        this.employee_id_division = employee_id_division;
        this.employee_birthday = employee_birthday;
        this.employee_id_card = employee_id_card;
        this.employee_salary = employee_salary;
        this.employee_phone = employee_phone;
        this.employee_email = employee_email;
        this.employee_address = employee_address;
        this.employee_user_name = employee_user_name;
    }

    public Employee(int employee_id, String employee_name, int employee_id_position, int employee_id_education,
                    int employee_id_division, String employee_birthday, String employee_id_card, double employee_salary,
                    String employee_phone, String employee_email, String employee_address, String employee_user_name) {
        this.employee_id = employee_id;
        this.employee_name = employee_name;
        this.employee_id_position = employee_id_position;
        this.employee_id_education = employee_id_education;
        this.employee_id_division = employee_id_division;
        this.employee_birthday = employee_birthday;
        this.employee_id_card = employee_id_card;
        this.employee_salary = employee_salary;
        this.employee_phone = employee_phone;
        this.employee_email = employee_email;
        this.employee_address = employee_address;
        this.employee_user_name = employee_user_name;
    }

    public Employee(String employee_name, int employee_id_position, int employee_id_education, int employee_id_division,
                    String employee_birthday, String employee_id_card, double employee_salary, String employee_phone,
                    String employee_email, String employee_address) {
        this.employee_name = employee_name;
        this.employee_id_position = employee_id_position;
        this.employee_id_education = employee_id_education;
        this.employee_id_division = employee_id_division;
        this.employee_birthday = employee_birthday;
        this.employee_id_card = employee_id_card;
        this.employee_salary = employee_salary;
        this.employee_phone = employee_phone;
        this.employee_email = employee_email;
        this.employee_address = employee_address;
    }

    public Employee(int employee_id, String employee_name, int employee_id_position, int employee_id_education,
                    int employee_id_division, String employee_birthday, String employee_id_card, double employee_salary,
                    String employee_phone, String employee_email, String employee_address) {
        this.employee_id = employee_id;
        this.employee_name = employee_name;
        this.employee_id_position = employee_id_position;
        this.employee_id_education = employee_id_education;
        this.employee_id_division = employee_id_division;
        this.employee_birthday = employee_birthday;
        this.employee_id_card = employee_id_card;
        this.employee_salary = employee_salary;
        this.employee_phone = employee_phone;
        this.employee_email = employee_email;
        this.employee_address = employee_address;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public int getEmployee_id_position() {
        return employee_id_position;
    }

    public void setEmployee_id_position(int employee_id_position) {
        this.employee_id_position = employee_id_position;
    }

    public int getEmployee_id_education() {
        return employee_id_education;
    }

    public void setEmployee_id_education(int employee_id_education) {
        this.employee_id_education = employee_id_education;
    }

    public int getEmployee_id_division() {
        return employee_id_division;
    }

    public void setEmployee_id_division(int employee_id_division) {
        this.employee_id_division = employee_id_division;
    }

    public String getEmployee_birthday() {
        return employee_birthday;
    }

    public void setEmployee_birthday(String employee_birthday) {
        this.employee_birthday = employee_birthday;
    }

    public String getEmployee_id_card() {
        return employee_id_card;
    }

    public void setEmployee_id_card(String employee_id_card) {
        this.employee_id_card = employee_id_card;
    }

    public double getEmployee_salary() {
        return employee_salary;
    }

    public void setEmployee_salary(double employee_salary) {
        this.employee_salary = employee_salary;
    }

    public String getEmployee_phone() {
        return employee_phone;
    }

    public void setEmployee_phone(String employee_phone) {
        this.employee_phone = employee_phone;
    }

    public String getEmployee_email() {
        return employee_email;
    }

    public void setEmployee_email(String employee_email) {
        this.employee_email = employee_email;
    }

    public String getEmployee_address() {
        return employee_address;
    }

    public void setEmployee_address(String employee_address) {
        this.employee_address = employee_address;
    }

    public String getEmployee_user_name() {
        return employee_user_name;
    }

    public void setEmployee_user_name(String employee_user_name) {
        this.employee_user_name = employee_user_name;
    }
}
