package com.codegym.model.repository;

import com.codegym.model.bean.BorrowCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBorrowCodeRepository extends JpaRepository<BorrowCode,Long> {
}
