package com.secondassignment.CourseRegistration.service.transformer;

import com.secondassignment.CourseRegistration.domain.Course;
import com.secondassignment.CourseRegistration.service.dto.CourseResponce;
import com.secondassignment.CourseRegistration.service.dto.CreateCourseRequest;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class CreateCourseTranform {
    public static Course createStudentRequestToDomain(CreateCourseRequest createCourseRequest){
        Course std = new Course();
        BeanUtils.copyProperties(createCourseRequest,std);
        return std;
    }
    /*public static Course updateStudentRequestToDomain(UpdateStudentRequest updateStudentRequest){
        Course std = new Course();
        BeanUtils.copyProperties(updateStudentRequest,std);
        return std;
    }*/
    public static CourseResponce studentDomainToResponse(Course std){
        CourseResponce stdr = new CourseResponce();
        BeanUtils.copyProperties(std,stdr);
        return stdr;
    }
    public static List<CourseResponce> studentDomainListToResponseList(List<Course> studentDomainObjectList){
        List<CourseResponce> studentResponseList = new ArrayList<CourseResponce>();
        for (Course student : studentDomainObjectList) {
            CourseResponce responseObject =   studentDomainToResponse(student);
            studentResponseList.add(responseObject);
        }
        return studentResponseList;
    }
}
