package model.repository.customer;

import model.bean.customer.TypeCustomer;

import java.util.List;

public interface ICustomerTypeRepo {
    List<TypeCustomer> selectAll();
}
