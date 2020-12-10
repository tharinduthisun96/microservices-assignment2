package com.secondassignment.CourseRegistration.service.base;

import com.secondassignment.CourseRegistration.domain.Course;
import com.secondassignment.CourseRegistration.repository.CourseRepository;
import com.secondassignment.CourseRegistration.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceBase implements CourseService {
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Course create(Course c) {
        return courseRepository.save(c);
    }

    @Override
    public Course update(Course c) {
        return courseRepository.save(c);
    }

    @Override
    public Course delete(Integer c) {
        Course course = courseRepository.findByCourseId(c);
        courseRepository.delete(course);
        return course;
    }

    @Override
    public List<Course> index() {
        return courseRepository.findAll();
    }

    public Course findById(Integer c) {
        return courseRepository.findByCourseId(c);
    }
}
