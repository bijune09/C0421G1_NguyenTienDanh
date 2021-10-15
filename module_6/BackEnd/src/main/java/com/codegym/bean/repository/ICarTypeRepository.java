package com.codegym.bean.repository;

import com.codegym.bean.model.CarType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICarTypeRepository extends JpaRepository<CarType, Long> {
}
