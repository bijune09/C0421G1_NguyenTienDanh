package com.codegym.model.service.employee;

import com.codegym.model.bean.employee.Division;
import com.codegym.model.repository.employee.IDivisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionServiceImpl implements IDivisionService {

    @Autowired
    private IDivisionRepository divisionRepository;

    @Override
    public List<Division> findAll() {
        return this.divisionRepository.findAll();
    }
}
