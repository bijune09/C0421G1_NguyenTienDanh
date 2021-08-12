package model.repository.employee.tag;

import model.bean.employee.Division;

import java.util.List;

public interface IDivisionRepo {
    List<Division> selectAll();
}
