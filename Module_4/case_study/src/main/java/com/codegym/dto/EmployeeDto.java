package com.codegym.dto;

import com.codegym.model.bean.contract.Contract;
import com.codegym.model.bean.employee.Division;
import com.codegym.model.bean.employee.EducationDegree;
import com.codegym.model.bean.employee.Position;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

public class EmployeeDto {
    private Long id;
    @NotEmpty(message = "You must input something")
    private String name;
    private String birthday;
    @NotEmpty(message = "You must input something")
    @Pattern(regexp = "^(\\d{9}|\\d{10})$", message = "Incorrect, try again." +
            "\n It can be 9 or 10 number")
    private String idCard;
    @Min(value = 1,message = "Salary must be positive")
    private Double salary;
    @NotEmpty(message = "You must input something")
    @Pattern(regexp = "^(09[0-1]\\d{7})$", message = "Incorrect, try again." +
            "\n Ex:090-xxxxxxx")
    private String phone;
    @Email(message = "Email isn't valid")
    private String email;
    @NotEmpty(message = "You must input something")
    private String address;
    private Position position;
    private EducationDegree educationDegree;
    private Division division;
    private List<Contract> contracts;

    public EmployeeDto() {
    }

    public EmployeeDto(String name, String birthday, String idCard, Double salary, String phone, String email, String address, Position position, EducationDegree educationDegree, Division division, List<Contract> contracts) {
        this.name = name;
        this.birthday = birthday;
        this.idCard = idCard;
        this.salary = salary;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.position = position;
        this.educationDegree = educationDegree;
        this.division = division;
        this.contracts = contracts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }
}
