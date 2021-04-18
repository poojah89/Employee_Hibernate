package com.organization.employeeprojdb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.organization.employeeprojdb.domain.model.Employee;
import com.organization.employeeprojdb.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService service;
	
	@GetMapping
	public ResponseEntity getEmployees() {
		
		List<Employee> resp = service.getAllEmployees();
		
		return new ResponseEntity(resp,HttpStatus.OK);
	}
	

	@PostMapping
	public ResponseEntity createEmployees(@RequestBody Employee emp) {
		
		Employee resp = service.createEmployee(emp);
		
		return new ResponseEntity(resp,HttpStatus.OK);
	}

}
