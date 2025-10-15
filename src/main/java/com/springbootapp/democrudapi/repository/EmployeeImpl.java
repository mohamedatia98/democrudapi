package com.springbootapp.democrudapi.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springbootapp.democrudapi.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeImpl implements EmployeeDao {

    // define filed for entity manager
    private EntityManager entityManager;

    // define constructor for injection
    @Autowired
    public EmployeeImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {
        // create query
        TypedQuery<Employee> theequery = entityManager.createQuery("from Employee", Employee.class);

        // get result query
        List<Employee> employees = theequery.getResultList();
        // return query

        return employees;
    }

}
