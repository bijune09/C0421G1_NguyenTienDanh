package model.service.customer_using_contract;

import model.bean.customer_using_contract.CustomerUsing;

import java.util.List;

public interface ICustomerUsingService {
    List<CustomerUsing> selectAll();
    CustomerUsing findById(int id);
    void deleteCustomerUsing(int id);
    void editCustomerUsing(CustomerUsing customerUsing);
}
