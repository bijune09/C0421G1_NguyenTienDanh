package model.service.employee;

import model.bean.employee.Employee;
import model.repository.employee.EmployeeRepoImpl;
import model.repository.employee.IEmployeeRepo;

import java.sql.SQLException;
import java.util.List;

public class EmployeeServiceImpl implements IEmployeeService {
    private IEmployeeRepo employeeRepo = new EmployeeRepoImpl();
    @Override
    public List<Employee> selectAll() throws SQLException {
        return this.employeeRepo.selectAll();
    }

    @Override
    public void createEmployee(Employee employee) throws SQLException {
        this.employeeRepo.createEmployee(employee);
    }

    @Override
    public Employee findById(int id) {
        return this.employeeRepo.findById(id);
    }

    @Override
    public boolean deleteEmployee(int id) {
        return this.employeeRepo.deleteEmployee(id);
    }

    @Override
    public boolean editEmployee(Employee employee) {
        return this.employeeRepo.editEmployee(employee);
    }
}
