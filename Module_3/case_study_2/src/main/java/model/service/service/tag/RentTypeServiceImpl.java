package model.service.service.tag;

import model.bean.service.RentType;
import model.repository.service.tag.IRentTypeRepo;
import model.repository.service.tag.RentTypeRepoImpl;

import java.util.List;

public class RentTypeServiceImpl implements IRentTypeService {
    private IRentTypeRepo rentTypeRepo = new RentTypeRepoImpl();
    @Override
    public List<RentType> selectAll() {
        return this.rentTypeRepo.selectAll();
    }
}
