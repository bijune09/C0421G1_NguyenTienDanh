package model.service.customer;

import model.bean.customer.Customer;
import model.repository.customer.CustomerRepoImpl;
import model.repository.customer.ICustomerRepo;
import model.service.common.Regex;

import java.util.ArrayList;
import java.util.List;

public class CustomerServiceImpl implements ICustomerService, Regex {
    private ICustomerRepo customerRepo = new CustomerRepoImpl();
    @Override
    public List<Customer> selectAll() {
        return this.customerRepo.selectAll();
    }

    @Override
    public Customer findById(int id) {
        return this.customerRepo.findById(id);
    }

    @Override
    public void editCustomer(Customer customer) {
        this.customerRepo.editCustomer(customer);
    }

    @Override
    public void deleteCustomer(int id) {
        this.customerRepo.deleteCustomer(id);
    }

    @Override
    public List<String> createCustomer(Customer customer) {
        List<String> message = new ArrayList<>();
        boolean check = true;
        String msg = null;

        if (!customer.getCustomerCode().matches(CUSTOMER_CODE)) {
            check = false;
            msg = "Incorrect, Please Try Again.(Ex:KH-XXXX,X is number)";
            message.add(msg);
        }

        if (!customer.getCustomerName().matches(REGEX_NAME)) {
            check = false;
            msg = "Incorrect name, Please try again";
            message.add(msg);
        }

        if (!customer.getCustomerIdCard().matches(ID_CARD)) {
            check = false;
            msg = "Incorrect format, Please try again";
            message.add(msg);
        }

        if (!customer.getCustomerPhone().matches(PHONE_NUMBER)) {
            check = false;
            msg = "Incorrect format, Please try again";
            message.add(msg);
        }

        if (!customer.getCustomerEmail().matches(EMAIL)) {
            check = false;
            msg = "Incorrect format, Please try again";
            message.add(msg);
        }

        if (check){
            this.customerRepo.createCustomer(customer);
        }
        return message;
    }
}
