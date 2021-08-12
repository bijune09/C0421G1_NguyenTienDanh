package model.service.service;

import model.bean.service.Service;
import model.repository.service.IServiceRepo;
import model.repository.service.ServiceRepoImpl;

import java.util.List;

public class ServiceServiceImpl implements IServiceService{
    private IServiceRepo serviceRepo = new ServiceRepoImpl();
    @Override
    public List<Service> selectAll() {
        return this.serviceRepo.selectAll();
    }

    @Override
    public Service findById(int id) {
        return this.serviceRepo.findById(id);
    }

    @Override
    public void createService(Service service) {
        this.serviceRepo.createService(service);
    }

    @Override
    public void editService(Service service) {
        this.serviceRepo.editService(service);
    }

    @Override
    public void deleteService(int id) {
        this.serviceRepo.deleteService(id);
    }
}
