package com.codegym.model.service.service;

import com.codegym.model.bean.service.RentType;

import com.codegym.model.repository.service.IRentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentTypeServiceImpl implements IRentTypeService {
    @Autowired
    private IRentTypeRepository rentTypeRepository;

    @Override
    public List<RentType> findAll() {
        return this.rentTypeRepository.findAll();
    }
}
