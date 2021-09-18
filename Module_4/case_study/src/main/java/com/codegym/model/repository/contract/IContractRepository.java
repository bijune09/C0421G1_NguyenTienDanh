package com.codegym.model.repository.contract;

import com.codegym.model.bean.contract.Contract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContractRepository extends JpaRepository<Contract,Long> {
}
