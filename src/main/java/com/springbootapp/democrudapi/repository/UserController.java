package com.springbootapp.democrudapi.repository;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootapp.democrudapi.entity.Employee;

@RestController
@RequestMapping("/api")
public class UserController {

    private EmployeeDao employeeDao;

    // inject employee ( Constructor inejction )

    public UserController(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    // get endpoint to check the employees
    @GetMapping("/employees")
    public List<Employee> getlist() {
        return employeeDao.findAll();

    }

}
