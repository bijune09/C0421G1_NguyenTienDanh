package com.codegym.model.repository.service;

import com.codegym.model.bean.service.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEntityServiceRepository extends JpaRepository<Service,Long> {
}
