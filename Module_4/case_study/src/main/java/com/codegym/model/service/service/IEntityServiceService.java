package com.codegym.model.service.service;

import com.codegym.model.bean.service.Service;

import java.util.List;

public interface IEntityServiceService {
    void save(Service service);

    List<Service> findAll();
}
