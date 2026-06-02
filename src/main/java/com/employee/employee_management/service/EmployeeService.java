package com.employee.employee_management.service;
import com.employee.employee_management.entity.Employee;
import com.employee.employee_management.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service //it is spring component that creates objects automatically (shortening the code)
public class EmployeeService {
    @Autowired //dependency injection - spring automatically injects repository object no need to manually create
    private EmployeeRepository employeeRepository;
    public Employee addEmployee(Employee employee) { //save employee to database
        return employeeRepository.save(employee);
    }
    public List<Employee> getAllEmployees() { //fetching all employees
        return employeeRepository.findAll();
    }
    public Optional<Employee> getEmployeeById(Long id) { //fetching all employees using their ids
        return employeeRepository.findById(id);
    }
    public Employee updateEmployee(Employee employee) { //updates existing employees
        return employeeRepository.save(employee);
    }
    public void deleteEmployee(Long id) { //deletes employees 
        employeeRepository.deleteById(id);
    }
}