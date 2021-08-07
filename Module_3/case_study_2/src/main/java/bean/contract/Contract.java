package bean.contract;

import java.util.Date;

public class Contract {
    private int idContract;
    private int idEmployee;
    private int idCustomer;
    private Date startDate;
    private Date endDate;
    private double totalMoney;

    public Contract() {
    }

    public Contract(int idContract, int idEmployee, int idCustomer, Date startDate, Date endDate, double totalMoney) {
        this.idContract = idContract;
        this.idEmployee = idEmployee;
        this.idCustomer = idCustomer;
        this.startDate = startDate;
        this.endDate = endDate;
        this.totalMoney = totalMoney;
    }

    public Contract(int idEmployee, int idCustomer, Date startDate, Date endDate, double totalMoney) {
        this.idEmployee = idEmployee;
        this.idCustomer = idCustomer;
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }
}
