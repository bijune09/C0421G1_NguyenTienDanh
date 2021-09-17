package com.codegym.model.repository.employee;

import com.codegym.model.bean.employee.EducationDegree;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEducationRepository extends JpaRepository<EducationDegree, Long> {
}
