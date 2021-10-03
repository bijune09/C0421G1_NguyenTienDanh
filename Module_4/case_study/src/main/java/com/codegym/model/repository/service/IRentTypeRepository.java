package com.codegym.model.repository.service;

import com.codegym.model.bean.service.RentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRentTypeRepository extends JpaRepository<RentType, Long> {
}