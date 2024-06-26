package com.grt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grt.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
