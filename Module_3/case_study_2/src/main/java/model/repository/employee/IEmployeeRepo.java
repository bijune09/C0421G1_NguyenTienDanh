package model.repository.employee;

import model.bean.employee.Employee;

import java.sql.SQLException;
import java.util.List;

public interface IEmployeeRepo {
    List<Employee> selectAll() throws SQLException;

    void createEmployee(Employee employee) throws SQLException;

    Employee findById(int id);

    boolean deleteEmployee(int id);

    boolean editEmployee(Employee employee);


}
