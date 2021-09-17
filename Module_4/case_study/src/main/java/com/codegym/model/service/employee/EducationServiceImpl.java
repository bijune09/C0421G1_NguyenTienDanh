package com.codegym.model.service.employee;

import com.codegym.model.bean.employee.EducationDegree;
import com.codegym.model.repository.employee.IEducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EducationServiceImpl implements IEducationService {

    @Autowired
    private IEducationRepository educationRepository;

    @Override
    public List<EducationDegree> findAll() {
        return this.educationRepository.findAll();
    }
}
