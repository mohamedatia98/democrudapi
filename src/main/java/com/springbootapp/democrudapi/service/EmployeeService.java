package com.springbootapp.democrudapi.service;

import java.util.List;

import com.springbootapp.democrudapi.entity.Employee;

public interface EmployeeService {

    List<Employee> findAll();

}
