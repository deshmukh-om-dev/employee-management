package com.employee.employee_management.controller;

import com.employee.employee_management.entity.Employee;
import com.employee.employee_management.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employees")
@Slf4j
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<?> addEmployee(
            @Valid @RequestBody Employee employee) {

        try {

            log.info("Inside EmployeeController addEmployee()");

            Employee savedEmployee =
                    employeeService.addEmployee(employee);

            log.info("Employee created successfully with ID: {}",
                    savedEmployee.getId());

            return ResponseEntity.ok(savedEmployee);

        } catch (Exception exception) {

            log.error("Inside EmployeeController addEmployee() Error: ",
                    exception);

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(exception.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllEmployees() {

        try {

            log.info("Inside EmployeeController getAllEmployees()");

            return ResponseEntity.ok(
                    employeeService.getAllEmployees());

        } catch (Exception exception) {

            log.error("Inside EmployeeController getAllEmployees() Error: ",
                    exception);

            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(exception.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployeeById(
            @PathVariable Long id) {

        try {

            log.info("Fetching employee with ID: {}", id);

            return ResponseEntity.ok(
                    employeeService.getEmployeeById(id));

        } catch (Exception exception) {

            log.error("Employee not found with ID: {}", id, exception);

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(exception.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmployee(
            @PathVariable Long id,
            @Valid @RequestBody Employee employee) {

        try {

            log.info("Updating employee with ID: {}", id);

            employee.setId(id);

            Employee updatedEmployee =
                    employeeService.updateEmployee(employee);

            log.info("Employee updated successfully");

            return ResponseEntity.ok(updatedEmployee);

        } catch (Exception exception) {

            log.error("Error updating employee with ID: {}", id, exception);

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(exception.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(
            @PathVariable Long id) {

        try {

            log.info("Deleting employee with ID: {}", id);

            employeeService.deleteEmployee(id);

            log.info("Employee deleted successfully");

            return ResponseEntity.ok(
                    "Employee Deleted Successfully");

        } catch (Exception exception) {

            log.error("Error deleting employee with ID: {}", id, exception);

            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(exception.getMessage());
        }
    }
}