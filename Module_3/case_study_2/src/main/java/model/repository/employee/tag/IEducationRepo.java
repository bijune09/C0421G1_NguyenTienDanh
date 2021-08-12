package model.repository.employee.tag;

import model.bean.employee.Education;

import java.util.List;

public interface IEducationRepo {
    List<Education> selectAll();
}
