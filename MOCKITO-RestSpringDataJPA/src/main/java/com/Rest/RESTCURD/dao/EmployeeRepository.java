package com.Rest.RESTCURD.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Rest.RESTCURD.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
}
