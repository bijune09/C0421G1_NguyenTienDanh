package model.service.implement;

import model.bean.Employee;
import model.common.Regex;
import model.repository.IEmployeeRepository;
import model.repository.implement.EmployeeRepositoryImplement;
import model.service.IEmployeeService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeServiceImpl implements IEmployeeService, Regex {
    private IEmployeeRepository employeeRepository = new EmployeeRepositoryImplement();
    @Override
    public List<Employee> selectAll() {
        return this.employeeRepository.selectAll();
    }

    @Override
    public Map<String, String> createEmployee(Employee employee) {
        Map<String,String> messageMap = new HashMap<>();
        boolean check = true;
        String msg = null;
        if (!employee.getName().matches(REGEX_NAME)){
            check = false;
            msg = "Incorrect Name Format. Please try again!";
            messageMap.put("name",msg);
        }
        if (!employee.getIdCard().matches(ID_CARD)){
            check = false;
            msg = "Incorrect Id Card Format. Please try again!";
            messageMap.put("idCard",msg);
        }
        if (!employee.getPhone().matches(PHONE_NUMBER)){
            check = false;
            msg = "Incorrect Phone Format. Please try again!";
            messageMap.put("Phone",msg);
        }
        if (check){
            this.employeeRepository.createEmployee(employee);
        }
        return messageMap;
    }

    @Override
    public Map<String, String> editEmployee(Employee employee) {
        Map<String,String> messageMap = new HashMap<>();
        boolean check = true;
        String msg = null;
        if (!employee.getName().matches(REGEX_NAME)){
            check = false;
            msg = "Incorrect Name Format. Please try again!";
            messageMap.put("name",msg);
        }
        if (!employee.getIdCard().matches(ID_CARD)){
            check = false;
            msg = "Incorrect Id Card Format. Please try again!";
            messageMap.put("email",msg);
        }
        if (!employee.getPhone().matches(PHONE_NUMBER)){
            check = false;
            msg = "Incorrect Phone Format. Please try again!";
            messageMap.put("Phone",msg);
        }
        if (check){
            this.employeeRepository.editEmployee(employee);
        }
        return messageMap;
    }

    @Override
    public void deleteEmployee(int id) {
        this.employeeRepository.removeEmployee(id);
    }

    @Override
    public Employee findById(int id) {
        return this.employeeRepository.findById(id);
    }

    @Override
    public List<Employee> findByChar(String character) {
        return this.employeeRepository.findByChar(character);
    }
}
