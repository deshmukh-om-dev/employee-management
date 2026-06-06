package com.employee.employee_management;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class EmployeeManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementApplication.class, args);
	}

}
/* JSON valid input
{
  "name": "Om Deshmukh",
  "email": "deshmukh.omworks@gmail.com",
  "department": "AI and Robotics",
  "salary": 50000,
  "joiningDate": "2026-05-29"
  gender:{
  
  }

}
 */