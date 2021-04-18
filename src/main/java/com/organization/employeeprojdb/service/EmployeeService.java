package com.organization.employeeprojdb.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.organization.employeeprojdb.domain.model.Employee;
import com.organization.employeeprojdb.exception.InternalException;
import com.organization.employeeprojdb.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	public List<Employee> getAllEmployees(){
		
		return employeeRepository.findAll();
		
	}
	
	public Employee getEmployeeById(Long employeeId) {
		
		Employee employee = employeeRepository.getOne(employeeId);
		return employee;
		
	}
	
	public Employee createEmployee(Employee employee) {
		
		return employeeRepository.save(employee);
	}
	
	public Employee updateEmployee(Long employeeId, Employee employeeDetails) throws InternalException {
		
		//Optional<Employee> employee = employeeRepository.findById(employeeId);
		
		//employee.
		Employee employee = employeeRepository.findById(employeeId)
	            .orElseThrow(() -> new InternalException(400, "Employee not found for this id :: " + employeeId,""));
		
		employee.setEmailId(employeeDetails.getEmailId());
        employee.setLastName(employeeDetails.getLastName());
        employee.setFirstName(employeeDetails.getFirstName());
        
        final Employee updatedEmployee = employeeRepository.save(employee);
        return updatedEmployee;
		
		
		
	}
	
	public Map<String, Boolean> deleteEmployee(Long employeeId) throws InternalException{
		
		Employee employee = employeeRepository.findById(employeeId)
	            .orElseThrow(() -> new InternalException(400, "Employee not found for this id :: " + employeeId,""));
		
		employeeRepository.delete(employee);
        Map < String, Boolean > response = new HashMap < > ();
        return response;
		
	}
	

}
