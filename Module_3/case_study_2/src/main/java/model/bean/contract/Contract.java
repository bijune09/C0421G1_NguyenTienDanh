package model.bean.contract;

import java.util.Date;

public class Contract {
    private int idContract;
    private int idEmployee;
    private int idCustomer;
    private int idService;
    private String startDate;
    private String endDate;
    private double totalMoney;

    public Contract() {
    }

    public Contract(int idContract, int idEmployee, int idCustomer, int idService, String startDate, String endDate, double totalMoney) {
        this.idContract = idContract;
        this.idEmployee = idEmployee;
        this.idCustomer = idCustomer;
        this.idService = idService;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalMoney = totalMoney;
    }

    public Contract(int idEmployee, int idCustomer, int idService, String startDate, String endDate, double totalMoney) {
        this.idEmployee = idEmployee;
        this.idCustomer = idCustomer;
        this.idService = idService;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalMoney = totalMoney;
    }

    public int getIdContract() {
        return idContract;
    }

    public void setIdContract(int idContract) {
        this.idContract = idContract;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public int getIdService() {
        return idService;
    }

    public void setIdService(int idService) {
        this.idService = idService;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }
}
