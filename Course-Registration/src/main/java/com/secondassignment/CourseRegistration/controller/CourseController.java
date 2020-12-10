package com.secondassignment.CourseRegistration.controller;

import com.secondassignment.CourseRegistration.domain.Course;
import com.secondassignment.CourseRegistration.service.CourseService;
import com.secondassignment.CourseRegistration.service.dto.CourseResponce;
import com.secondassignment.CourseRegistration.service.dto.CreateCourseRequest;
import com.secondassignment.CourseRegistration.service.transformer.CreateCourseTranform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/course")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody CourseResponce Create(@RequestBody CreateCourseRequest createStudentRequest){
        Course course = CreateCourseTranform.createStudentRequestToDomain(createStudentRequest);
        Course studentResponse = courseService.create(course);
        return CreateCourseTranform.studentDomainToResponse(studentResponse);

    }

    @RequestMapping("/course/delete/{id}")
    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody CourseResponce Delete(@PathVariable Integer id){
        Course studentResponse = courseService.delete(id);
        return CreateCourseTranform.studentDomainToResponse(studentResponse);

    }
    @RequestMapping("/course/update")
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody CourseResponce Update(@RequestBody CreateCourseRequest updateStudentRequest){
        Course student = CreateCourseTranform.createStudentRequestToDomain(updateStudentRequest);
        Course studentResponse = courseService.update(student);
        return CreateCourseTranform.studentDomainToResponse(studentResponse);

    }

    @RequestMapping("/course/{id}")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody CourseResponce getById(@PathVariable Integer id){
        Course studentResponse = courseService.findById(id);
        return CreateCourseTranform.studentDomainToResponse(studentResponse);

    }
}
