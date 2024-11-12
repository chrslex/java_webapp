package com.chrslex.demo.dao;

import com.chrslex.demo.entity.Employee;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDAO extends JpaRepository<Employee, Integer> {

    
    public Employee findByFirstNameAndLastName(String lastName, String firstName);
}
