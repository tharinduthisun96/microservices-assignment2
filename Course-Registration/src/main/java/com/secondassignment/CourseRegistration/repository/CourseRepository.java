package com.secondassignment.CourseRegistration.repository;


import com.secondassignment.CourseRegistration.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, String> {
    Course deleteByCourseId(Integer s);
    Course findByCourseId(Integer s);
}