package com.codegym.controller;

import com.codegym.bean.model.CarType;
import com.codegym.bean.model.Station;
import com.codegym.bean.service.StationService;
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
@RequestMapping("station")
public class StationRestController {

    @Autowired
    private StationService stationService;

    @GetMapping
    public ResponseEntity<List<Station>> findAll(){
        List<Station> carTypeList = this.stationService.findAll();
        if (carTypeList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(carTypeList,HttpStatus.OK);
    }
}
