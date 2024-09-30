package com.chrslex.demo.rest;

import com.chrslex.demo.entity.Employee;
import com.chrslex.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    // possible upsert
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
//        employee.setEmployeeId(0);

        Employee savedEmployee = employeeService.save(employee);
        return savedEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        if(employee.getEmployeeId() == 0) {
            System.out.println(employee);
            throw new RuntimeException("No ID Detected");
        }
        Employee savedEmployee = employeeService.save(employee);

        return savedEmployee;

    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {
        Employee toDelete = employeeService.findById(employeeId);
        if(toDelete == null) {
            throw new RuntimeException("Employee with id " + employeeId + " not found");
        }
        employeeService.deleteById(employeeId);
        return "Deleted Employee with id " + employeeId;
    }
}
