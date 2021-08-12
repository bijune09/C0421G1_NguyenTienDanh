package model.repository.service;

import model.bean.service.Service;

import java.util.List;

public interface IServiceRepo {
    List<Service> selectAll();
    Service findById(int id);
    void createService(Service service);
    void editService(Service service);
    void deleteService(int id);
}
