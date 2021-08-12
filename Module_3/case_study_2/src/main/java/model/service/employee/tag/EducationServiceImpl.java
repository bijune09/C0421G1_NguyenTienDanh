package model.service.employee.tag;

import model.bean.employee.Education;
import model.repository.employee.tag.EducationRepoImpl;
import model.repository.employee.tag.IEducationRepo;

import java.util.List;

public class EducationServiceImpl implements IEducationService {
    private IEducationRepo educationRepo = new EducationRepoImpl();
    @Override
    public List<Education> selectAll() {
        return this.educationRepo.selectAll();
    }
}
