package com.codegym.model.service;

import com.codegym.model.bean.BorrowCode;

public interface IBorrowCodeService {
    void save(BorrowCode borrowCode);
    BorrowCode findById(Long id);
    void remove(Long id);
}
