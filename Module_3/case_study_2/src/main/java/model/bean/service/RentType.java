package model.bean.service;

public class RentType {
    private int idRentType;
    private String rentType;

    public RentType() {
    }

    public RentType(int idRentType, String rentType) {
        this.idRentType = idRentType;
        this.rentType = rentType;
    }

    public int getIdRentType() {
        return idRentType;
    }

    public void setIdRentType(int idRentType) {
        this.idRentType = idRentType;
    }

    public String getRentType() {
        return rentType;
    }

    public void setRentType(String rentType) {
        this.rentType = rentType;
    }
}
