package com.Rest.RESTCURD;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.Rest.RESTCURD.dao.EmployeeRepository;
import com.Rest.RESTCURD.entity.Employee;
import com.Rest.RESTCURD.service.EmployeeService;


class ServiceTest {
	
	@Mock
	private EmployeeRepository repository;
	
	@InjectMocks
	private EmployeeService empService;
	
	@BeforeEach
	public void setUp()
	{
		MockitoAnnotations.openMocks(this);
		empService = new EmployeeService();
	}
	
	@Test
	void test() {
		//assertNull(repository);
		assertNotNull(repository, "It should not be null");
	}
	
	@Test
	void testFind() {
		Employee employee = new Employee();
		assertNotNull(repository, "It should not be null");
		when(repository.findById(1)).thenReturn(Optional.of(employee));
		Employee find = empService.find(1);
		assertNotNull(find);
	}

}
