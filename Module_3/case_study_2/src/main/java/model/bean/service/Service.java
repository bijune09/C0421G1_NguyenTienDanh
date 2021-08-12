package model.bean.service;

public class Service {
    private int idService;
    private String nameService;
    private int serviceArea;
    private int floor;
    private int capacity;
    private double rent_cost;
    private int idRentType;
    private int idServiceType;
    private String description;
    private String standard;
    private double poolArea;

    public Service() {
    }

    public Service(String nameService, int serviceArea, int floor, int capacity, double rent_cost, int idRentType,
                   int idServiceType, String description, String standard, double poolArea) {
        this.nameService = nameService;
        this.serviceArea = serviceArea;
        this.floor = floor;
        this.capacity = capacity;
        this.rent_cost = rent_cost;
        this.idRentType = idRentType;
        this.idServiceType = idServiceType;
        this.description = description;
        this.standard = standard;
        this.poolArea = poolArea;
    }

    public Service(int idService, String nameService, int serviceArea, int floor, int capacity, double rent_cost,
                   int idRentType, int idServiceType, String description, String standard, double poolArea) {
        this.idService = idService;
        this.nameService = nameService;
        this.serviceArea = serviceArea;
        this.floor = floor;
        this.capacity = capacity;
        this.rent_cost = rent_cost;
        this.idRentType = idRentType;
        this.idServiceType = idServiceType;
        this.description = description;
        this.standard = standard;
        this.poolArea = poolArea;
    }

    public int getIdService() {
        return idService;
    }

    public void setIdService(int idService) {
        this.idService = idService;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public int getServiceArea() {
        return serviceArea;
    }

    public void setServiceArea(int serviceArea) {
        this.serviceArea = serviceArea;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public double getRent_cost() {
        return rent_cost;
    }

    public void setRent_cost(double rent_cost) {
        this.rent_cost = rent_cost;
    }

    public int getIdRentType() {
        return idRentType;
    }

    public void setIdRentType(int idRentType) {
        this.idRentType = idRentType;
    }

    public int getIdServiceType() {
        return idServiceType;
    }

    public void setIdServiceType(int idServiceType) {
        this.idServiceType = idServiceType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }
}
