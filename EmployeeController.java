package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping("/employee")
	public String addEmployee(@RequestBody Employee emp) {
		employeeService.addEmployee(emp);
		return "Employee Added Sucessfully";
	}
	
	@GetMapping("/employee")
	public List<Employee> getAllEmployee(@RequestBody Employee emp) {
		List<Employee> lstList = employeeService.getAllEmployee();
		return lstList;
	}
	
	@GetMapping("/employee/countByName/{name}")
	public int getEmployeeCountByName(@PathVariable String name) {
		int count = employeeService.getEmployeeCountByName(name);
		return count;
	}

}
