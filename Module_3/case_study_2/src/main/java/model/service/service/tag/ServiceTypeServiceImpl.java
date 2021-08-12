package model.service.service.tag;

import model.bean.service.ServiceType;
import model.repository.service.tag.IServiceTypeRepo;
import model.repository.service.tag.ServiceTypeRepoImpl;
import model.service.service.IServiceService;

import java.util.List;

public class ServiceTypeServiceImpl implements IServiceTypeService {
    private IServiceTypeRepo serviceTypeRepo = new ServiceTypeRepoImpl();
    @Override
    public List<ServiceType> selectAll() {
        return this.serviceTypeRepo.selectAll();
    }
}
