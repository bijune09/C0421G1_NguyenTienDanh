package model.repository.employee.tag;

import model.bean.employee.Position;

import java.util.List;

public interface IPositionRepo {
    List<Position> selectAll();
}
