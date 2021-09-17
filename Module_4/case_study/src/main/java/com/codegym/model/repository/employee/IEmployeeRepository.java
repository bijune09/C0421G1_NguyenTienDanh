package com.codegym.model.repository.employee;

import com.codegym.model.bean.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<Employee,Long> {
    Page<Employee> findAllByNameContaining(String name, Pageable pageable);
}
