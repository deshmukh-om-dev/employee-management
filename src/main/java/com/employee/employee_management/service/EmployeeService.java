package com.employee.employee_management.service;

import com.employee.employee_management.entity.Employee;
import com.employee.employee_management.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee) {

        try {

            log.info("Inside EmployeeService addEmployee()");

            Employee savedEmployee =
                    employeeRepository.save(employee);

            log.info("Employee saved successfully with ID: {}",
                    savedEmployee.getId());

            return savedEmployee;

        } catch (Exception exception) {

            log.error("Error while saving employee: ",
                    exception);

            throw exception;
        }
    }

    public List<Employee> getAllEmployees() {

        try {

            log.info("Inside EmployeeService getAllEmployees()");

            return employeeRepository.findAll();

        } catch (Exception exception) {

            log.error("Error while fetching employees: ",
                    exception);

            throw exception;
        }
    }

    public Employee getEmployeeById(Long id) {

        try {

            log.info("Fetching employee with ID: {}", id);

            return employeeRepository.findById(id)
                    .orElseThrow(() -> {

                        log.error("Employee not found with ID: {}", id);

                        return new RuntimeException(
                                "Employee with ID " + id + " not found");
                    });

        } catch (Exception exception) {

            log.error("Error while fetching employee: ",
                    exception);

            throw exception;
        }
    }

    public Employee updateEmployee(Employee employee) {

        try {

            if (!employeeRepository.existsById(employee.getId())) {

                log.error("Employee not found with ID: {}",
                        employee.getId());

                throw new RuntimeException(
                        "Employee with ID "
                                + employee.getId()
                                + " not found");
            }

            log.info("Updating employee with ID: {}",
                    employee.getId());

            Employee updatedEmployee =
                    employeeRepository.save(employee);

            log.info("Employee updated successfully");

            return updatedEmployee;

        } catch (Exception exception) {

            log.error("Error while updating employee: ",
                    exception);

            throw exception;
        }
    }

    public void deleteEmployee(Long id) {

        try {

            Employee employee =
                    employeeRepository.findById(id)
                            .orElseThrow(() -> {

                                log.error("Employee not found with ID: {}", id);

                                return new RuntimeException(
                                        "Employee with ID "
                                                + id
                                                + " not found");
                            });

            employeeRepository.delete(employee);

            log.info("Employee deleted successfully");

        } catch (Exception exception) {

            log.error("Error while deleting employee: ",
                    exception);

            throw exception;
        }
    }
}