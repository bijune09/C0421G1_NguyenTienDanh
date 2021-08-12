package model.repository.contract;

import model.bean.contract.Contract;

import java.util.List;

public interface IContractRepo {
    List<Contract> selectAll();
    void createContract(Contract contract);
    void editContract(Contract contract);
    void deleteContract(int id);
    Contract findById(int id);
}
