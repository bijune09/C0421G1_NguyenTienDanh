package model.service.contract;

import model.bean.contract.Contract;

import java.util.List;

public interface IContractService {
    List<Contract> selectAll();
    void createContract(Contract contract);
    void editContract(Contract contract);
    void deleteContract(int id);
    Contract findById(int id);
}
