package com.secondassignment.CourseRegistration.service;

import com.secondassignment.CourseRegistration.domain.Course;

import java.util.List;

public interface CourseService {
    Course create(Course s);
    Course update(Course s);
    Course delete(Integer s);
    List<Course> index();
    public Course findById(Integer s);
}
