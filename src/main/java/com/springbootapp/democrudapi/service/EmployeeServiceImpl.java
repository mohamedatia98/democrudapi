package com.springbootapp.democrudapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootapp.democrudapi.entity.Employee;
import com.springbootapp.democrudapi.repository.EmployeeDao;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    // setup constructor injection
    private EmployeeDao employeeDoa;

    @Autowired
    public EmployeeServiceImpl(EmployeeDao employeeDoa) {
        this.employeeDoa = employeeDoa;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDoa.findAll();
    }

    @Override
    public Employee findById(int theId) {
        return employeeDoa.findById(theId);
    }

    @Override
    @Transactional
    public Employee save(Employee employee) {
        return employeeDoa.save(employee);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        employeeDoa.deleteById(theId);
    }

}
