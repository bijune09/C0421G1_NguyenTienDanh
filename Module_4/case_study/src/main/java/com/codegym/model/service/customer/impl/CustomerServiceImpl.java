package com.codegym.model.service.customer.impl;

import com.codegym.model.bean.customer.Customer;
import com.codegym.model.repository.customer.ICustomerRepository;
import com.codegym.model.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
@Service
@Transactional
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return this.customerRepository.findAll(pageable);
    }

    @Override
    public void save(Customer customer) {
        this.customerRepository.save(customer);
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return this.customerRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
        this.customerRepository.deleteById(id);
    }

    @Override
    public Page<Customer> findByName(String name, Pageable pageable) {
        return this.customerRepository.findAllByNameContaining(name,pageable);
    }
}
