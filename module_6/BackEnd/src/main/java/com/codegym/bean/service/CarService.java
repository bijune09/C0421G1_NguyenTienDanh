package com.codegym.bean.service;

import com.codegym.bean.exception.CarNotFoundException;
import com.codegym.bean.model.Car;
import com.codegym.bean.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CarService implements ICarService {
    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }


    @Override
    public Page<Car> findAll(Pageable pageable) {
        return this.carRepository.findAll(pageable);
    }

    @Override
    public Car findById(Long id) {
        return this.carRepository.findById(id).orElse(null);
    }

    @Override
    public Car save(Car car) {
        return this.carRepository.save(car);
    }

    @Override
    public void delete(Long id) {
        this.carRepository.deleteById(id);
    }


}
