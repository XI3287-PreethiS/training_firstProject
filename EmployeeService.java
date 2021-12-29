package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private CustomSequenceService customSequenceService;
	
	
	public void addEmployee(Employee emp) {
		int empId =customSequenceService.getNextSequence("empSequence");
		emp.setId(empId);
		employeeRepository.save(emp);
		
	
	}

	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
		
	}

	public int getEmployeeCountByName(String name) {
		int count = employeeRepository.getEmployeeCountByName(name);
		return count;
	}

}
