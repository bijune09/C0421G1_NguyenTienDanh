package model.service.customer;

import model.bean.customer.Customer;

import java.util.List;
import java.util.Map;

public interface ICustomerService {
    List<Customer> selectAll();
    Customer findById(int id);
    void editCustomer(Customer customer);
    void deleteCustomer(int id);
    Map<String, String> createCustomer(Customer customer);
}
