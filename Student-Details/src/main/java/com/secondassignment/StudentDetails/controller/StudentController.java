package com.secondassignment.StudentDetails.controller;


import com.secondassignment.StudentDetails.domain.Student;
import com.secondassignment.StudentDetails.service.StudentService;
import com.secondassignment.StudentDetails.service.dto.CreateStudentRequest;
import com.secondassignment.StudentDetails.service.dto.StudentResponse;
import com.secondassignment.StudentDetails.service.dto.UpdateStudentRequest;
import com.secondassignment.StudentDetails.service.transformer.CreateStudentTransform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;


    @RequestMapping("/student")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody
    StudentResponse Create(@RequestBody CreateStudentRequest createStudentRequest){
        Student student = CreateStudentTransform.createStudentRequestToDomain(createStudentRequest);
        Student studentResponse = studentService.create(student);
        return CreateStudentTransform.studentDomainToResponse(studentResponse);

    }

    @RequestMapping("/student/all")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody List<StudentResponse> Index(){

        List<Student> studentResponse = studentService.index();
        return CreateStudentTransform.studentDomainListToResponseList(studentResponse);

    }
    @RequestMapping("/student/delete/{id}")
    @DeleteMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody StudentResponse Delete(@PathVariable Integer id){
        Student studentResponse = studentService.delete(id);
        return CreateStudentTransform.studentDomainToResponse(studentResponse);

    }
    @RequestMapping("/student/update")
    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody StudentResponse Update(@RequestBody UpdateStudentRequest updateStudentRequest){
        Student student = CreateStudentTransform.updateStudentRequestToDomain(updateStudentRequest);
        Student studentResponse = studentService.update(student);
        return CreateStudentTransform.studentDomainToResponse(studentResponse);

    }

    @RequestMapping("/student/{id}")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody StudentResponse getById(@PathVariable Integer id){
        Student studentResponse = studentService.findById(id);
        return CreateStudentTransform.studentDomainToResponse(studentResponse);

    }
}
