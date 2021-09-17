package com.codegym.dto;

import com.codegym.model.bean.contract.Contract;
import com.codegym.model.bean.customer.CustomerType;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

public class CustomerDto {
    private Long id;
    private CustomerType customerType;
    @NotNull(message = "You must input something")
    private String name;
    private String birthday;
    private boolean gender;
    @NotNull(message = "You must input something")
    @Pattern(regexp = "^(\\d{9}|\\d{10})$", message = "Incorrect, try again." +
            "\n It can be 9 or 10 number")
    private String idCard;
    @NotNull(message = "You must input something")
    @Pattern(regexp = "^(09[0-1]\\d{7})$", message = "Incorrect, try again." +
            "\n Ex:090-xxxxxxx or 091-xxxxxxx")
    private String phone;
    private String email;
    @NotNull(message = "You must input something")
    private String address;
    private List<Contract> contracts;
    @NotNull(message = "You must input something")
    @Pattern(regexp = "^KH-\\d{4}$", message = "Incorrect, try again." +
            "\n Ex:KH-xxxx. x is number")
    private String code;

    public CustomerDto() {
    }

    public CustomerDto(CustomerType customerType, @NotNull(message = "You must input something") String name, String birthday, boolean gender, @NotNull(message = "You must input something") @Pattern(regexp = "^(\\\\d{9}|\\\\d{10})$", message = "Incorrect, try again." +
            "\n It can be 9 or 10 number") String idCard, @NotNull(message = "You must input something") @Pattern(regexp = "^^(09[0-1]\\\\d{7})|(\\\\(84\\\\)\\\\+9[01]\\\\d{7})$$", message = "Incorrect, try again." +
            "\n Ex:090-xxxxxxx or 091-xxxxxxx") String phone, String email, @NotNull(message = "You must input something") String address, List<Contract> contracts, @NotNull(message = "You must input something") @Pattern(regexp = "^KH-\\d{4}$", message = "Incorrect, try again." +
            "\n Ex:KH-xxxx. x is number") String code) {
        this.customerType = customerType;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.idCard = idCard;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.contracts = contracts;
        this.code = code;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
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

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
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

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
