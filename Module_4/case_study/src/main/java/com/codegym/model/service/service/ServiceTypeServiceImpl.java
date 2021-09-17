package com.codegym.model.service.service;

import com.codegym.model.bean.service.ServiceType;
import com.codegym.model.repository.service.IServiceTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceTypeServiceImpl implements IServiceTypeService {
    @Autowired
    private IServiceTypeRepository serviceTypeRepository;

    @Override
    public List<ServiceType> findAll() {
        return this.serviceTypeRepository.findAll();
    }
}
