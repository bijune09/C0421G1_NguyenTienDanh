package com.codegym.model.service.employee;

import com.codegym.model.bean.employee.Position;
import com.codegym.model.repository.employee.IPositionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PositionServiceImpl implements IPositionService {

    @Autowired
    private IPositionRepository positionRepository;

    @Override
    public List<Position> findAll() {
        return this.positionRepository.findAll();
    }
}
