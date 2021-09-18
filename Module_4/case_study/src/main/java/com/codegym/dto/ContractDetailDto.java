package com.codegym.dto;

import com.codegym.model.bean.contract.AttachService;
import com.codegym.model.bean.contract.Contract;
import javax.validation.constraints.Min;

public class ContractDetailDto {
    private Long id;
    private AttachService attachService;
    private Contract contract;
    @Min(value = 1,message = "Quantity must be positive")
    private int quantity;

    public ContractDetailDto() {
    }

    public ContractDetailDto(AttachService attachService, Contract contract, @Min(value = 1, message = "Quantity must be positive") int quantity) {
        this.attachService = attachService;
        this.contract = contract;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
