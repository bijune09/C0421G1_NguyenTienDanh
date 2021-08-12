package model.service.customer;

import model.bean.customer.TypeCustomer;
import model.repository.customer.CustomerTypeRepoImpl;
import model.repository.customer.ICustomerTypeRepo;

import java.util.List;

public class CustomerTypeServiceImpl implements ICustomerTypeService{
    private ICustomerTypeRepo customerTypeRepo = new CustomerTypeRepoImpl();
    @Override
    public List<TypeCustomer> selectAll() {
        return this.customerTypeRepo.selectAll();
    }
}
