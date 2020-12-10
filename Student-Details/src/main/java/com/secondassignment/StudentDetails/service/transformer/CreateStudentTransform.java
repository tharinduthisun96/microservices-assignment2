package com.secondassignment.StudentDetails.service.transformer;

import com.secondassignment.StudentDetails.domain.Student;
import com.secondassignment.StudentDetails.service.dto.CreateStudentRequest;
import com.secondassignment.StudentDetails.service.dto.StudentResponse;
import com.secondassignment.StudentDetails.service.dto.UpdateStudentRequest;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class CreateStudentTransform {
    public static Student createStudentRequestToDomain(CreateStudentRequest createStudentRequest){
        Student std = new Student();
        BeanUtils.copyProperties(createStudentRequest,std);
        return std;
    }
    public static Student updateStudentRequestToDomain(UpdateStudentRequest updateStudentRequest){
        Student std = new Student();
        BeanUtils.copyProperties(updateStudentRequest,std);
        return std;
    }
    public static StudentResponse studentDomainToResponse(Student std){
        StudentResponse stdr = new StudentResponse();
        BeanUtils.copyProperties(std,stdr);
        return stdr;
    }
    public static List<StudentResponse> studentDomainListToResponseList(List<Student> studentDomainObjectList){
        List<StudentResponse> studentResponseList = new ArrayList<StudentResponse>();
        for (Student student : studentDomainObjectList) {
            StudentResponse responseObject =   studentDomainToResponse(student);
            studentResponseList.add(responseObject);
        }
        return studentResponseList;
    }
}
