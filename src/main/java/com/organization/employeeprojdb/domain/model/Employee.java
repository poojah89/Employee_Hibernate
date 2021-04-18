package com.organization.employeeprojdb.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Table(name = "employees")
@Data
public class Employee {
	
	
		@Id
		@NotNull
		@Column(name = "id")
		@GeneratedValue(strategy = GenerationType.AUTO)
	  	private long id;
	  	
		@Column(name = "first_name", nullable = false)
	    private String firstName;
		
		@Column(name = "last_name", nullable = false)
	    private String lastName;
	    
		@Column(name = "email_address", nullable = false)
	    private String emailId;
	    
	    

}
