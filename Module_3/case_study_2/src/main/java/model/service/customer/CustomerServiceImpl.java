package model.service.customer;

import model.bean.customer.Customer;
import model.repository.customer.CustomerRepoImpl;
import model.repository.customer.ICustomerRepo;

import java.util.List;

public class CustomerServiceImpl implements ICustomerService {
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
    public void createCustomer(Customer customer) {
        this.customerRepo.createCustomer(customer);
    }
}
