package model.service.contract;

import model.bean.contract.Contract;
import model.repository.contract.ContractRepo;
import model.repository.contract.IContractRepo;

import java.util.List;

public class ContractServiceImpl implements IContractService{
    private IContractRepo contractRepo = new ContractRepo();
    @Override
    public List<Contract> selectAll() {
        return this.contractRepo.selectAll();
    }

    @Override
    public void createContract(Contract contract) {
        this.contractRepo.createContract(contract);
    }

    @Override
    public void editContract(Contract contract) {
        this.contractRepo.editContract(contract);
    }

    @Override
    public void deleteContract(int id) {
        this.contractRepo.deleteContract(id);
    }

    @Override
    public Contract findById(int id) {
        return this.contractRepo.findById(id);
    }
}
