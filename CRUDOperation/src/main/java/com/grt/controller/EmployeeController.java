package com.grt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grt.Service.EmployeeService;
import com.grt.model.Employee;

@RestController
@RequestMapping("api/employees")
public class EmployeeController {
	
	private EmployeeService employeeService;
	
	
	
	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
    
	//POST REST API
	@PostMapping
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee),HttpStatus.CREATED);
	}
	
	//GET REST API
	@GetMapping
	public List<Employee> getEmployee(){
		return employeeService.getEmployee();
	}
	
	//GET REST API FOR ID
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable long id){
		return new ResponseEntity<Employee>(employeeService.getEmployeeById(id),HttpStatus.OK);
	}
	
	//PUT REST API
	@PutMapping()
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
		return new ResponseEntity<Employee>(employeeService.updateEmployee(employee),HttpStatus.OK);
	}
	
	@PatchMapping("{id}")
	public Employee patchEmployee(@PathVariable long id,@RequestBody Map<String, Object> fields){
		return employeeService.patchEmployee(id, fields);

	}
	
	//DELETE REST API
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable long id) {
		employeeService.deleteEmployee(id);
		return new ResponseEntity<String>("Data deleted succesfully.", HttpStatus.OK);
	}
	}