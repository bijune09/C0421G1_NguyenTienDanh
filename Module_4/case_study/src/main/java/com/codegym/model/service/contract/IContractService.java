package com.codegym.model.service.contract;

import com.codegym.model.bean.contract.Contract;

import java.util.List;

public interface IContractService {
    List<Contract> findAll();
    void save(Contract contract);
}
