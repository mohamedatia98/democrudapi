package com.springbootapp.democrudapi.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootapp.democrudapi.entity.Employee;
import com.springbootapp.democrudapi.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class UserController {

    private EmployeeService employeeService;

    // inject employee ( Constructor inejction )
    @Autowired
    public UserController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // get endpoint to check the employees
    @GetMapping("/employees")
    public List<Employee> getlist() {
        return employeeService.findAll();

    }

}
