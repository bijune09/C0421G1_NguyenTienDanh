package model.bean.service;

public class ServiceType {
    private int idServiceType;
    private String ServiceType;

    public ServiceType() {
    }

    public ServiceType(int idServiceType, String serviceType) {
        this.idServiceType = idServiceType;
        ServiceType = serviceType;
    }

    public int getIdServiceType() {
        return idServiceType;
    }

    public void setIdServiceType(int idServiceType) {
        this.idServiceType = idServiceType;
    }

    public String getServiceType() {
        return ServiceType;
    }

    public void setServiceType(String serviceType) {
        ServiceType = serviceType;
    }
}
