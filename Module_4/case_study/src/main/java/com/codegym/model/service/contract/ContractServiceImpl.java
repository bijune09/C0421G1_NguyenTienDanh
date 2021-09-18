package com.codegym.model.service.contract;

import com.codegym.model.bean.contract.Contract;
import com.codegym.model.repository.contract.IContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractServiceImpl implements IContractService {

    @Autowired
    private IContractRepository contractRepository;

    @Override
    public List<Contract> findAll() {
        return this.contractRepository.findAll();
    }

    @Override
    public void save(Contract contract) {
        this.contractRepository.save(contract);
    }
}
