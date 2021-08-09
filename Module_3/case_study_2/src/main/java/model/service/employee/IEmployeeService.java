package model.service.employee;

import model.bean.employee.Employee;

import java.sql.SQLException;
import java.util.List;

public interface IEmployeeService {
    List<Employee> selectAll() throws SQLException;

    void createEmployee(Employee employee) throws SQLException;

    Employee findById(int id);

    boolean deleteEmployee(int id);

    boolean editEmployee(Employee employee);
}
