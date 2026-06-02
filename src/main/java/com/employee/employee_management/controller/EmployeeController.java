package com.employee.employee_management.controller;
import com.employee.employee_management.entity.Employee; //imports employee class
import com.employee.employee_management.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired; //imports dependency injection annotations
import org.springframework.web.bind.annotation.*; //Imports all REST API annotations together
import java.util.List; //imports list
import java.util.Optional; //imports optional class
@RestController //this class handles REST APIs and returns JSON responses
@RequestMapping("/employees") //sets base URL when u check in postman
public class EmployeeController {
    @Autowired //dependency injection
    private EmployeeService employeeService; // service object injected
    @PostMapping //handles adding of elements like adding of employee
    public Employee addEmployee(
            @Valid @RequestBody Employee employee) { //triggers validation annotations
        return employeeService.addEmployee(employee);
    }
    @GetMapping //fetches all employees
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
    @GetMapping("/{id}") //fetches all employees by id
    public Optional<Employee> getEmployeeById(
            @PathVariable Long id) { //takes id from URL
        return employeeService.getEmployeeById(id);
    }
    @PutMapping("/{id}") //updates the employee details
    public Employee updateEmployee(
            @PathVariable Long id,//takes id from URLs
            @Valid @RequestBody Employee employee) {
        employee.setId(id);
        return employeeService.updateEmployee(employee);
    }
    @DeleteMapping("/{id}") //deletes employee using id
    public String deleteEmployee(
            @PathVariable Long id) {//takes id from URL
        employeeService.deleteEmployee(id);
        return "Employee Deleted Successfully";
    }
}