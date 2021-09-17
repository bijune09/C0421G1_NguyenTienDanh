package com.codegym.model.service.employee;

import com.codegym.model.bean.employee.EducationDegree;

import java.util.List;

public interface IEducationService {
    List<EducationDegree> findAll();
}
