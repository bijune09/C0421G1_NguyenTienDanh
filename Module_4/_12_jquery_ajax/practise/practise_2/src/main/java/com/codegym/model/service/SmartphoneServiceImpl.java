package com.codegym.model.service;

import com.codegym.model.bean.Smartphone;
import com.codegym.model.repository.ISmartphoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
@Service
@Transactional
public class SmartphoneServiceImpl implements ISmartphoneService{
    @Autowired
    private ISmartphoneRepository smartphoneRepository;

    @Override
    public Iterable<Smartphone> findAll() {
        return smartphoneRepository.findAll();
    }

    @Override
    public Optional<Smartphone> findById(Long id) {
        return smartphoneRepository.findById(id);
    }

    @Override
    public Smartphone save(Smartphone smartphone) {
        return this.smartphoneRepository.save(smartphone);
    }

    @Override
    public void remove(Long id) {
        this.smartphoneRepository.deleteById(id);
    }
}
