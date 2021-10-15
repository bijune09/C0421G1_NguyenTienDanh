package com.codegym.controller;

import com.codegym.bean.model.CarType;
import com.codegym.bean.service.CarTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("carType")
public class CarTypeRestController {

    @Autowired
    private CarTypeService carTypeService;

    @GetMapping
    public ResponseEntity<List<CarType>> findAll(){
        List<CarType> carTypeList = this.carTypeService.findAll();
        if (carTypeList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(carTypeList,HttpStatus.OK);
    }
}
