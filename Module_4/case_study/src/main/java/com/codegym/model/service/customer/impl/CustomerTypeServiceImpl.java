package com.codegym.model.service.customer.impl;

import com.codegym.model.bean.customer.CustomerType;
import com.codegym.model.repository.ICustomerTypeRepository;
import com.codegym.model.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CustomerTypeServiceImpl implements ICustomerTypeService {
    @Autowired
    private ICustomerTypeRepository customerTypeRepository;

    @Override
    public List<CustomerType> findAll() {
        return this.customerTypeRepository.findAll();
    }
}
