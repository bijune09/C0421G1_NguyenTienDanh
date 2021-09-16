package com.codegym.model.service.customer;

import com.codegym.model.bean.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ICustomerService {
    Page<Customer> findAll(Pageable pageable);

    void save(Customer customer);

    Optional<Customer> findById(Long id);

    void remove(Long id);

    Page<Customer> findByName(String name,Pageable pageable);
}
