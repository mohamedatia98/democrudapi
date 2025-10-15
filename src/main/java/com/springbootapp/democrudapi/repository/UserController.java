package com.springbootapp.democrudapi.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    // GET API code
    @GetMapping("/employees/{employeeid}")
    public Employee getMyEmployee(@PathVariable int employeeid) {

        return employeeService.findById(employeeid);
    }

    // POST API
    @PostMapping("/employees")
    public Employee postnewEmployee(@RequestBody Employee employee) {
        // set id to zero incase so it will create new item instead of update
        employee.setId(0);

        Employee employee1 = employeeService.save(employee);
        return employee1;
    }

    // Put Mapping
    @PutMapping("/employees")
    public Employee updateemployee(@RequestBody Employee employee) {
        // TODO: process PUT request
        Employee myeEmployee = employeeService.save(employee);

        return myeEmployee;
    }

}
