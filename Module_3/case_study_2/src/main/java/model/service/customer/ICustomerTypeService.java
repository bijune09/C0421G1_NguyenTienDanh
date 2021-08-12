package model.service.customer;

import model.bean.customer.TypeCustomer;

import java.util.List;

public interface ICustomerTypeService {
    List<TypeCustomer> selectAll();
}
