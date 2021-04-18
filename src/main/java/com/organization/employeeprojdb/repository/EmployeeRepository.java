package com.organization.employeeprojdb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.organization.employeeprojdb.domain.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
