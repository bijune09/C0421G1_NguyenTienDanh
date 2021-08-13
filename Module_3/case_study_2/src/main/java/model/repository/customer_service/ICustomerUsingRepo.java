package model.repository.customer_service;

import model.bean.customer_using_contract.CustomerUsing;

import java.util.List;

public interface ICustomerUsingRepo {
    List<CustomerUsing> selectAll();
    CustomerUsing findById(int id);
    void edit(CustomerUsing customerUsing);
    void remove(int id);
}
