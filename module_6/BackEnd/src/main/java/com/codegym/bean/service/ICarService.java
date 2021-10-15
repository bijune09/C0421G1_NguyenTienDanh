package com.codegym.bean.service;

import com.codegym.bean.model.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICarService {
    Page<Car> findAll(Pageable pageable);

    Car findById(Long id);

    Car save(Car car);

    void delete(Long id);
}
