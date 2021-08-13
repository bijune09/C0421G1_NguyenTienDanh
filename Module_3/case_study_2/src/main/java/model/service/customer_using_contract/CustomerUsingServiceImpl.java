package model.service.customer_using_contract;

import model.bean.customer_using_contract.CustomerUsing;
import model.repository.customer_service.CustomerUsingRepoImpl;
import model.repository.customer_service.ICustomerUsingRepo;

import java.util.List;

public class CustomerUsingServiceImpl implements ICustomerUsingService {
    private ICustomerUsingRepo customerUsingRepo = new CustomerUsingRepoImpl();
    @Override
    public List<CustomerUsing> selectAll() {
        return this.customerUsingRepo.selectAll();
    }

    @Override
    public CustomerUsing findById(int id) {
        return this.customerUsingRepo.findById(id);
    }

    @Override
    public void deleteCustomerUsing(int id) {
        this.customerUsingRepo.remove(id);
    }

    @Override
    public void editCustomerUsing(CustomerUsing customerUsing) {
        this.customerUsingRepo.edit(customerUsing);
    }
}
