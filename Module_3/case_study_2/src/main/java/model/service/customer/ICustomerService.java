package model.service.customer;

import model.bean.customer.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> selectAll();
    Customer findById(int id);
    void editCustomer(Customer customer);
    void deleteCustomer(int id);
    List<String> createCustomer(Customer customer);
}
