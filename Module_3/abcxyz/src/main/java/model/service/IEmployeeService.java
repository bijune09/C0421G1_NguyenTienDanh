package model.service;

import model.bean.Employee;

import java.util.List;
import java.util.Map;

public interface IEmployeeService {
    List<Employee> selectAll();
    Map<String,String> createEmployee(Employee employee);
    Map<String,String> editEmployee(Employee employee);
    void deleteEmployee(int id);
    Employee findById(int id);
    List<Employee> findByChar(String character);
}
