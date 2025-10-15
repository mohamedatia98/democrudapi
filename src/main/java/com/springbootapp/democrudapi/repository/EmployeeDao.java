package com.springbootapp.democrudapi.repository;

// this is interface for DAO (all Crud Methods Here !)

import java.util.List;

import com.springbootapp.democrudapi.entity.Employee;

public interface EmployeeDao {

    List<Employee> findAll();

}
