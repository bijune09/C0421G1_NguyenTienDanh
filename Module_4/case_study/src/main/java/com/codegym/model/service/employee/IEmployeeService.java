package com.codegym.model.service.employee;

import com.codegym.model.bean.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IEmployeeService {
    Page<Employee> findAll(Pageable pageable);

    void save(Employee employee);

    Employee findById(Long id);

    Page<Employee> findByName(String name, Pageable pageable);
}
