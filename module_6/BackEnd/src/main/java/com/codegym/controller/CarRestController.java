package com.codegym.controller;


import com.codegym.bean.model.Car;
import com.codegym.bean.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("car")
public class CarRestController {

    @Autowired
    private CarService carService;

    @GetMapping
    public ResponseEntity<?> findAll(@PageableDefault(value = 5) Pageable pageable) {
        Page<Car> carPage =  this.carService.findAll(pageable);
        if (carPage.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(carPage,HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Car> findById(@PathVariable Long id) {
        Car car = this.carService.findById(id);
        if (car != null){
            return new ResponseEntity<>(car, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/add")
    public ResponseEntity<Car> addNew(@RequestBody Car car){
        Car newCar = this.carService.save(car);
        return new ResponseEntity<>(newCar,HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Car> updateCar(@RequestBody Car car){
        Car editCar = this.carService.save(car);
        return new ResponseEntity<>(editCar,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id){
        this.carService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
