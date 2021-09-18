package com.codegym.model.service.employee;

import com.codegym.model.bean.employee.Employee;
import com.codegym.model.repository.employee.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    private IEmployeeRepository employeeRepository;

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return this.employeeRepository.findAll(pageable);
    }

    @Override
    public void save(Employee employee) {
        this.employeeRepository.save(employee);
    }

    @Override
    public Employee findById(Long id) {
        return this.employeeRepository.findById(id).get();
    }

    @Override
    public Page<Employee> findByName(String name, Pageable pageable) {
        return this.employeeRepository.findAllByNameContaining(name,pageable);
    }

    @Override
    public List<Employee> findAllList() {
        return this.employeeRepository.findAll();
    }

    @Override
    public void remove(Long id) {
        this.employeeRepository.deleteById(id);
    }


}
