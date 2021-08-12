package model.service.employee.tag;

import model.bean.employee.Position;
import model.repository.BaseRepository;
import model.repository.employee.tag.IPositionRepo;
import model.repository.employee.tag.PositionRepoImpl;

import java.util.List;

public class PositionServiceImpl implements IPositionService {
    private IPositionRepo positionRepo = new PositionRepoImpl();
    @Override
    public List<Position> selectAll() {
        return this.positionRepo.selectAll();
    }
}
