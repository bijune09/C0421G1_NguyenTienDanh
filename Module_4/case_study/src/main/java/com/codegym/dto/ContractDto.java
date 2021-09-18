package com.codegym.dto;

import com.codegym.model.bean.contract.ContractDetail;
import com.codegym.model.bean.customer.Customer;
import com.codegym.model.bean.employee.Employee;
import com.codegym.model.bean.service.Service;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.List;

public class ContractDto {
    private Long id;
    @NotEmpty(message = "You must choose day")
    private String startDate;
    @NotEmpty(message = "You must choose day")
    private String endDate;
    @Min(value = 1,message = "Deposit must be positive")
    private double deposit;
    private Employee employee;
    private Customer customer;
    private Service service;
    private List<ContractDetail> contractDetails;

    public ContractDto() {
    }

    public ContractDto(String startDate, String endDate, @Min(value = 0, message = "Deposit must be positive") double deposit, Employee employee, Customer customer, Service service, List<ContractDetail> contractDetails) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.deposit = deposit;
        this.employee = employee;
        this.customer = customer;
        this.service = service;
        this.contractDetails = contractDetails;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public List<ContractDetail> getContractDetails() {
        return contractDetails;
    }

    public void setContractDetails(List<ContractDetail> contractDetails) {
        this.contractDetails = contractDetails;
    }
}
