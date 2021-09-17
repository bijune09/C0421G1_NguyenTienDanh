package com.codegym.model.repository.customer;

import com.codegym.model.bean.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer,Long> {
    Page<Customer> findAllByNameContaining(String name, Pageable pageable);
}
