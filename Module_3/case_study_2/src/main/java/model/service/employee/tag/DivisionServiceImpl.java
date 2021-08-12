package model.service.employee.tag;

import model.bean.employee.Division;
import model.repository.employee.tag.DivisionRepoImpl;
import model.repository.employee.tag.IDivisionRepo;

import java.util.List;

public class DivisionServiceImpl implements IDivisionService{
    private IDivisionRepo divisionRepo = new DivisionRepoImpl();
    @Override
    public List<Division> selectAll() {
        return this.divisionRepo.selectAll();
    }
}
