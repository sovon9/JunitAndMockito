package com.Rest.RESTCURD;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import com.Rest.RESTCURD.dao.EmployeeRepository;
import com.Rest.RESTCURD.entity.Employee;
import com.Rest.RESTCURD.service.EmployeeService;

@ExtendWith(MockitoExtension.class) // telling junit to run with Mockito
class ServiceTest2 {
	
	@Mock
	private EmployeeRepository repository;
	
	@InjectMocks
	private EmployeeService empService = new EmployeeService();
	
	@BeforeEach
	public void setUp()
	{
		MockitoAnnotations.openMocks(this);
		//empService = new EmployeeService();
	}
	
	@Test
	void test() {
		//assertNull(repository);
		assertNotNull(repository, "It should not be null");
	}
	
	@Test
	void testFind() {
		/*
		 * positive scenario testing where we are providing stubbing for Id 1 and it should
		 * return a employee obj successfully for id 1
		 */
		Employee employee = new Employee();
		when(repository.findById(1)).thenReturn(Optional.of(employee));
		Employee find = empService.find(1);
		assertNotNull(find);
		// verify verifies that this findById invoked actually or not during test execution
		verify(repository).findById(1); 
		// if you put verify(repository).findById(1) then it will say actual 
		// invocation have different arguments
	}
	
	@Test
	void testFindNegetiveScenario() {
		/*
		 * Negative scenario testing where we are returning optional empty
		 */
		when(repository.findById(1)).thenReturn(Optional.empty());
		assertThrows(RuntimeException.class, ()->{
			empService.find(1);
		});
		verify(repository).findById(1);
	}
	
	@Test
	void testFindExceptionScenario() {
		/*
		 * Another scenario testing where we are providing stubbing for Id 1 and it should
		 * throw Runtime exception for any other id
		 */
		Employee employee = new Employee();
		when(repository.findById(1)).thenReturn(Optional.of(employee));
		assertThrows(RuntimeException.class, ()->{
			empService.find(2);
		});
		verify(repository).findById(2);
	}
	

}
