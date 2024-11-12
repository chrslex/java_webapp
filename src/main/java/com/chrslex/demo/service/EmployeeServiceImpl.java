package com.chrslex.demo.service;

import com.chrslex.demo.dao.EmployeeDAO;
import com.chrslex.demo.entity.Employee;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        return employeeDAO.findById(id).orElseGet(null);
        
    }


    @Override
    @Transactional
    public Employee save(Employee employee) {
        return employeeDAO.save(employee);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        try{
            Employee e = employeeDAO.findById(id).orElseThrow();

        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public Employee findByFirstNameAndLastName(String fn, String ln){

        return employeeDAO.findByFirstNameAndLastName(fn, ln);
    }
}
