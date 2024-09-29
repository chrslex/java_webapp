package com.chrslex.demo.rest;

import com.chrslex.demo.entity.Employee;
import com.chrslex.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAllEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee findEmployeeById(@PathVariable int id) {
        Employee employee = employeeService.findById(id);
        if(employee == null) {
            throw new RuntimeException("Employee with id " + id + " not found");
        }
        return employee;
    }

}
