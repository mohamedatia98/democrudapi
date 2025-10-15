package com.springbootapp.democrudapi.service;

import java.util.List;

import com.springbootapp.democrudapi.entity.Employee;

public interface EmployeeService {

    List<Employee> findAll();

    // all Crud methods

    Employee findById(int theId);

    Employee save(Employee employee);

    void deleteById(int theId);
}
