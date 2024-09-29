package com.chrslex.demo.service;

import com.chrslex.demo.dao.EmployeeDAO;
import com.chrslex.demo.entity.Employee;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    public Employee findById(int id) {
        return employeeDAO.findById(id);
    }


    @Override
    @Transactional
    public Employee save(Employee employee) {
        Employee savedEmployee = employeeDAO.save(employee);
        return savedEmployee;
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Employee employee = employeeDAO.findById(id);
        employeeDAO.deleteById(id);
    }
}
