package com.codegym.model.repository.employee;

import com.codegym.model.bean.employee.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPositionRepository extends JpaRepository<Position, Long> {
}
