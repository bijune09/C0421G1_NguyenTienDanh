package com.codegym.dto;

import javax.validation.constraints.*;

public class UserDto {

    private int id;

    @NotEmpty(message = "First name must not be empty")
    @Size(min = 5,max = 45, message = "First name must contain at least 5 and not over 45 letter")
    private String firstName;
    @NotEmpty(message = "Last name must not be empty")
    @Size(min = 5,max = 45, message = "Last name must contain at least 5 and not over 45 letter")
    private String lastName;
    @NotEmpty(message = "Phone must not be empty")
    @Pattern(regexp = "(84|0[3|5|7|8|9])+([0-9]{8})\\b", message = "Your phone number isn't valid ")
    private String phoneNumber;
    @Min(value = 18)
    private int age;
    @Email(message = "Email is not valid")
    private String email;

    public UserDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
