package com.grt.EmployeeServiceImplementation;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import org.springframework.data.util.ReflectionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.grt.Service.EmployeeService;
import com.grt.model.Employee;
import com.grt.repository.EmployeeRepository;

@Service
public class EmployeeServiceImplementation implements EmployeeService {
	
	private EmployeeRepository employeeRepos;
	
	public EmployeeServiceImplementation(EmployeeRepository employeeRepos) {
		super();
		this.employeeRepos = employeeRepos;
	}


	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepos.save(employee);
	}

	@Override
	public Employee updateEmployee(Employee emp) {
		employeeRepos.findById(emp.getId()).orElseThrow(()-> new RuntimeException("Not found"));
		return employeeRepos.save(emp);
	}


	@Override
	public List<Employee> getEmployee() {
		return employeeRepos.findAll();
	}


	@Override
	public void deleteEmployee(long id) {
		employeeRepos.findById(id).orElseThrow(()-> new RuntimeException("Id not found"));
		employeeRepos.deleteById(id);
		
	}


	@Override
	public Employee getEmployeeById(long id) {
	    return employeeRepos.findById(id).orElseThrow(()-> new RuntimeException("Id not found"));
	}


	@Override
	public Employee patchEmployee(long id, Map<String, Object> fields) {
		Employee existEmployee = employeeRepos.findById(id).orElseThrow(()->new RuntimeException("Id not found.")); 
		fields.forEach((key, value)->{
			Field field = ReflectionUtils.findRequiredField(Employee.class, key);
			field.setAccessible(true);
			ReflectionUtils.setField(field, existEmployee, value);
		});
		return employeeRepos.save(existEmployee);
	}

	




}
