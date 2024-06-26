package com.grt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grt.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
