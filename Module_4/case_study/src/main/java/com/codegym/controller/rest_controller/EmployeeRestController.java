package com.codegym.controller.rest_controller;

import com.codegym.model.bean.employee.Employee;
import com.codegym.model.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
public class EmployeeRestController {
    @Autowired
    private IEmployeeService employeeService;

    @DeleteMapping("/{id}")
    public ResponseEntity<Employee> removeEmployee(@PathVariable Long id){
        Employee employee = this.employeeService.findById(id);
        if (employee == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.employeeService.remove(id);
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Long id){
        Employee employee = this.employeeService.findById(id);
        if (employee == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employee,HttpStatus.OK);
    }
}
