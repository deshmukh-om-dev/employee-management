package com.employee.employee_management.repository;
import com.employee.employee_management.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
public interface EmployeeRepository
        extends JpaRepository<Employee, Long> { //inherits database methods from JpaRepository
//JpaRepository automatically has the CRUD methods without writing SQL queries manually
}
//using interface here because spring automatically provides implementation we dont need to create them manually