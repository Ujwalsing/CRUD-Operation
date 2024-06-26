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

import com.grt.Service.CourseService;
import com.grt.model.Course;
import com.grt.model.Employee;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class CourseController {
	
	private final CourseService courseService;


	//Rest API for saving data of course
	@PostMapping
	public ResponseEntity<Course> saveCourse(@RequestBody Course course){
		return new ResponseEntity<Course>(courseService.saveCourse(course),HttpStatus.CREATED);
	}
	
	
	//Rest API for fetching all course data
	@GetMapping
	public List<Course> getAllCourses(){
		return courseService.getAllCourses();
	}
	
	//Rest API for fetching data by Id
	@GetMapping("{id}")
	public ResponseEntity<Course> getCourseById(@PathVariable("id") long id){
        return new ResponseEntity<Course>(courseService.getCourseById(id),HttpStatus.OK);
	}
	
//	Rest API for updating the data of course
//	http://localhost:8080/api/courses/1
	@PutMapping("{id}")
	public ResponseEntity<Course> updateCourse(@PathVariable("id") long id, @RequestBody Course course){
		return new ResponseEntity<Course>(courseService.updateCourse(course, id),HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<Course> updateCourse(@RequestBody Course course){
		return new ResponseEntity<Course>(courseService.updateCourse(course),HttpStatus.OK);
	}
	
	//Rest API for deleting the data
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteCourse(@PathVariable("id") long id){
	   courseService.deleteCourse(id);
	   return new ResponseEntity<String>("Successfully Deleted!",HttpStatus.OK);
	}
	
	@DeleteMapping
	public ResponseEntity<String> deleteCourseById(@RequestBody long id){
		courseService.deleteCourseById(id);
		return new ResponseEntity<String>("Successfully Deleted By Id",HttpStatus.OK);
	}
	
}
