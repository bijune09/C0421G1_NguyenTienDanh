package com.codegym.bean.service;

import com.codegym.bean.model.CarType;
import com.codegym.bean.repository.ICarTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CarTypeService {
    @Autowired
    private ICarTypeRepository carTypeRepository;

    public List<CarType> findAll(){
        return this.carTypeRepository.findAll();
    }
}
