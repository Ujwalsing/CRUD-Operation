package com.grt.CourseServiceImplementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.grt.Service.CourseService;
import com.grt.model.Course;
import com.grt.repository.CourseRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CourseServiceImplementation implements CourseService {

	private final CourseRepository courseRepos;

	@Override
	public Course saveCourse(Course course) {
		return courseRepos.save(course);
	}

	@Override
	public List<Course> getAllCourses() {
		return courseRepos.findAll();
	}

	@Override
	public Course getCourseById(long id) {
		return courseRepos.findById(id).orElseThrow(()-> new RuntimeException("Not Found"));
	}

	@Override
	public Course updateCourse(Course course, long id) {
		//Check for the course with course id exists in our table or not.
		Course existcourse = courseRepos.findById(id).orElseThrow(()-> new RuntimeException("Not found"));
		
		existcourse.setCourseName(course.getCourseName());
		existcourse.setCourseDesc(course.getCourseDesc());
		existcourse.setCoursePrice(course.getCoursePrice());
		courseRepos.save(existcourse);
		
		return existcourse;
	}
	
	//here you have send the existcourse directly which is why there was a problem 
	public Course updateCourseWithId(long id) {
		Course existcourse = courseRepos.findById(id).orElseThrow(()-> new RuntimeException("Not Found"));
		
		return existcourse;
	}

	@Override
	public Course updateCourse(Course course) {
		//Check for the course with course id exists in our table or not.
		Course existcourse = courseRepos.findById(course.getId()).orElseThrow(()-> new RuntimeException("Not found"));
		return courseRepos.save(course);
	}

	@Override
	public void deleteCourse(long id) {
		courseRepos.deleteById(id);
		
	}

	@Override
	public void deleteCourseById(long id) {
		courseRepos.deleteById(id);
		
	}







}
