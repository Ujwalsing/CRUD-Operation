package com.grt.Service;

import java.util.List;
import java.util.Map;

import com.grt.model.Employee;

public interface EmployeeService {
	Employee saveEmployee(Employee employee);
	List<Employee> getEmployee();
	Employee updateEmployee(Employee emp);
	void deleteEmployee(long id);
	Employee getEmployeeById(long id);  
    Employee patchEmployee(long id, Map<String, Object> fields);
}
