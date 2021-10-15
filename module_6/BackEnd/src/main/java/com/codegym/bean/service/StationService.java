package com.codegym.bean.service;

import com.codegym.bean.model.Station;
import com.codegym.bean.repository.IStationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class StationService {
    @Autowired
    private IStationRepository stationRepository;

    public List<Station> findAll(){
        return this.stationRepository.findAll();
    }
}
