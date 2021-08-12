package model.repository.customer;

import model.bean.customer.Customer;

import java.util.List;

public interface ICustomerRepo {
    List<Customer> selectAll();
    Customer findById(int id);
    void editCustomer(Customer customer);
    void deleteCustomer(int id);
    void createCustomer(Customer customer);
}
