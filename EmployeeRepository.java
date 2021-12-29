package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.demo.entity.Employee;

public interface EmployeeRepository extends MongoRepository<Employee, Integer> {

	Optional<Employee> findByName(String name);
	
	//@Query("new com.example.demo.dto.EmployeeDto(id, name) from employee")
	//Employee findByName(String name);
	
	
	@Query(value = "{name: ?0}", count = true)
	Integer getEmployeeCountByName(String name);

}
