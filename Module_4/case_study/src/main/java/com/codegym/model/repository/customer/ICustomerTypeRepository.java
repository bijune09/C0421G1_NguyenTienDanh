package com.codegym.model.repository.customer;

import com.codegym.model.bean.customer.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerTypeRepository extends JpaRepository<CustomerType,Long> {
}
