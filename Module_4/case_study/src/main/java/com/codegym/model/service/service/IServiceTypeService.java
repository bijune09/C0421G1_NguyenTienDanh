package com.codegym.model.service.service;

import com.codegym.model.bean.service.ServiceType;

import java.util.List;

public interface IServiceTypeService {
    List<ServiceType> findAll();
}
