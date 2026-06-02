//Employee.java is the Entity layer which maps Java objects to PostgreSQL table using Hibernate/JPA annotations
package com.employee.employee_management.entity; //java becomes a database here with employee table
import jakarta.persistence.*; // importing valid annotations
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import java.time.LocalDate;

@Entity //java becomes a database here with employee table
public class Employee {

    @Id //primary key of the table
    @GeneratedValue(strategy = GenerationType.IDENTITY) //id auto increments automatically as the entries increase
    //id, name, email, department, salary and join date are columns of the table
    private Long id;
    @NotBlank(message = "Name cannot be empty") //name should not be empty
    private String name;
    @Email(message = "Enter valid email") //checks proper email format
    private String email;
    private String department;
    @Positive(message = "Salary must be greater than 0") // checks that salary must be greater than 0 i.e positive
    private double salary;
    private LocalDate joiningDate;
    public Employee() { //constructor getters and setters to access and modify object data
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public LocalDate getJoiningDate() {
        return joiningDate;
    }
    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }
}