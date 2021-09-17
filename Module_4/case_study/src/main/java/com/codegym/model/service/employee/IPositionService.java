package com.codegym.model.service.employee;

import com.codegym.model.bean.employee.Position;

import java.util.List;

public interface IPositionService {
    List<Position> findAll();
}
