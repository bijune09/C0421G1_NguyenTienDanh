package com.codegym.model.service.service;

import com.codegym.model.bean.service.Service;
import com.codegym.model.repository.service.IEntityServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service
public class EntityServiceServiceImpl implements IEntityServiceService {
    @Autowired
    private IEntityServiceRepository entityServiceRepository;

    @Override
    public void save(Service service) {
        entityServiceRepository.save(service);
    }
}
