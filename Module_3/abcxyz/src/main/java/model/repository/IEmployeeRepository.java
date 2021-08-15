package model.repository;

import model.bean.Employee;

import java.util.List;

public interface IEmployeeRepository {
    List<Employee> selectAll();
    Employee findById(int id);
    void createEmployee(Employee employee);
    void removeEmployee(int id);
    void editEmployee(Employee employee);

    List<Employee> findByChar(String character);
}
