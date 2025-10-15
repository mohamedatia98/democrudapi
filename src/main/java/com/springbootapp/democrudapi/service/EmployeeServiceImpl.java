package com.springbootapp.democrudapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootapp.democrudapi.entity.Employee;
import com.springbootapp.democrudapi.repository.EmployeeDao;

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
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
