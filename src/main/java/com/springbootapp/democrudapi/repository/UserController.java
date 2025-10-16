package com.springbootapp.democrudapi.repository;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.springbootapp.democrudapi.entity.Employee;
import com.springbootapp.democrudapi.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class UserController {

    private ObjectMapper objectMapper; // injection

    private EmployeeService employeeService;

    // inject employee ( Constructor inejction )
    @Autowired
    public UserController(EmployeeService employeeService, ObjectMapper theObjectMapper) {
        this.employeeService = employeeService;
        objectMapper = theObjectMapper;
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

    // PATCH
    @PatchMapping("/employees/{employeeId}")
    public Employee patchEmployee(@PathVariable int employeeId,
            @RequestBody Map<String, Object> pathPayLoad) {
        Employee employee = employeeService.findById(employeeId);

        // throw exception if it is null
        if (employee == null) {
            throw new RuntimeException("Employee id not found");
        }
        //
        if (pathPayLoad.containsKey("id")) {
            throw new RuntimeException("Employee id not allowed in request body");
        }

        Employee employee1 = apply(pathPayLoad, employee);

        // Save the updated employee
        employeeService.save(employee1);

        return employee1;
    }

    private Employee apply(Map<String, Object> pathPayLoad, Employee employee) {

        // Convert employee object to a JSON object node
        ObjectNode empNode = objectMapper.convertValue(employee, ObjectNode.class);

        // Convert patchPayLoad map object to a JSON object node
        ObjectNode pathNode = objectMapper.convertValue(pathPayLoad, ObjectNode.class);

        // merge patch updates to employee node
        empNode.setAll(pathNode);

        return objectMapper.convertValue(empNode, Employee.class);
    }

    // Delete Mapping
    @DeleteMapping("/employees/{studentId}")
    public String deleteEmployee(@PathVariable int studentId) {
        Employee tEmployee = employeeService.findById(studentId);

        if (tEmployee == null) {
            throw new RuntimeException("Employee Id is not found " + studentId);
        }
        // remove object
        employeeService.deleteById(studentId);

        return ("Employee id : " + studentId + " is Deleted Now ");

    }
}
