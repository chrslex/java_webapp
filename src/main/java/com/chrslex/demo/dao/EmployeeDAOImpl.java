package com.chrslex.demo.dao;

import com.chrslex.demo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        // create query
        TypedQuery<Employee> query = entityManager.createQuery("FROM Employee e", Employee.class);
        // return the result
        return query.getResultList();
    }

    @Override
    public Employee findById(int id) {
        TypedQuery<Employee> query = entityManager.createQuery("FROM Employee e WHERE e.id = :id", Employee.class);
        query.setParameter("id", id);

        if (query.getResultList().isEmpty()){
            return null;
        }
        return query.getSingleResult();
    }

    @Override
    public Employee save(Employee employee) {
        Employee savedEmployee = entityManager.merge(employee);

        return savedEmployee;
    }

    @Override
    public void deleteById(int id) {
        Employee employee = entityManager.find(Employee.class, id);
        entityManager.remove(employee);
    }
}
