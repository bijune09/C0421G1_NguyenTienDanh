package com.codegym.model.bean.employee;

import com.codegym.model.bean.contract.Contract;
import com.codegym.model.bean.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String birthday;
    private String idCard;
    private Double salary;
    private String phone;
    private String email;
    private String address;

    @ManyToOne(targetEntity = Position.class)
    @JoinColumn(name = "position_id",referencedColumnName = "id")
    @JsonBackReference
    private Position position;


    @ManyToOne(targetEntity = EducationDegree.class)
    @JoinColumn(name = "education_degree_id",referencedColumnName = "id")
    @JsonBackReference
    private EducationDegree educationDegree;


    @ManyToOne(targetEntity = Division.class)
    @JoinColumn(name = "division_id",referencedColumnName = "id")
    @JsonBackReference
    private Division division;

    @OneToMany(mappedBy = "employee" ,cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Contract> contracts;

    @OneToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private User user;

    public Employee() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
