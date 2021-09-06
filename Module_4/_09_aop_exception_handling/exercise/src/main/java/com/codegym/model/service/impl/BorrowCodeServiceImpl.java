package com.codegym.model.service.impl;

import com.codegym.model.bean.BorrowCode;
import com.codegym.model.repository.IBorrowCodeRepository;
import com.codegym.model.service.IBorrowCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class BorrowCodeServiceImpl implements IBorrowCodeService {
    @Autowired
    private IBorrowCodeRepository borrowCodeRepository;

    @Override
    public void save(BorrowCode borrowCode) {
        borrowCodeRepository.save(borrowCode);
    }

    @Override
    public BorrowCode findById(Long id) {
        return borrowCodeRepository.findById(id).orElse(null);
    }

    @Override
    public void remove(Long id) {
        borrowCodeRepository.deleteById(id);
    }
}
