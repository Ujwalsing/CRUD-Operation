package com.grt.Service;

import java.util.List;

import com.grt.model.Course;

public interface CourseService {
	Course saveCourse(Course course);
	List<Course> getAllCourses();
	Course getCourseById(long id);
	Course updateCourse(Course course, long id);
	Course updateCourseWithId(long id);
	Course updateCourse(Course course);
	void deleteCourse(long id);
	void deleteCourseById(long id);
}
