package com.grt.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grt.Service.CompanyService;
import com.grt.model.Company;
import com.grt.model.Course;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/Company")
@RequiredArgsConstructor
public class CompanyController {
	
	private final CompanyService companyService;
	
	//REST API for POST Method
	@PostMapping
	public ResponseEntity<Company> saveCompany(@RequestBody Company company){
		return new ResponseEntity<Company>(companyService.saveCompany(company),HttpStatus.CREATED);
	}
	
	//REST API for GET
	@GetMapping
	public List<Company> getCompany(){
		return companyService.getCompany();
	}
	
	//REST API for GET by ID
	@GetMapping("{id}")
	public ResponseEntity<Company> getCourseByID(@PathVariable long id){
	return new ResponseEntity<Company>(companyService.getCompanyById(id),HttpStatus.OK);
	}
	
    //REST API for PUT
	@PutMapping
	public ResponseEntity<Company> updateCompany(@RequestBody Company company) {
		return new ResponseEntity<Company>(companyService.updateCompany(company),HttpStatus.OK);
	}
	
	//REST API for DELETE
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteCompany(@PathVariable long id){
		companyService.deleteCompany(id);
		return new ResponseEntity<String>("Data deleted successfully!",HttpStatus.OK);
	}
}
