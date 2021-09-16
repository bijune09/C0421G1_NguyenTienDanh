package com.codegym.model.service.customer;

import com.codegym.model.bean.customer.CustomerType;

import java.util.List;

public interface ICustomerTypeService {
    List<CustomerType> findAll();
}
