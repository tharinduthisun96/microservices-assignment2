package com.secondassignment.StudentDetails.service.base;

import com.secondassignment.StudentDetails.domain.Student;
import com.secondassignment.StudentDetails.repository.StudentRepository;
import com.secondassignment.StudentDetails.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceBase implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student create(Student s) {
        return studentRepository.save(s);
    }

    @Override
    public Student update(Student s) {
        return studentRepository.save(s);
    }

    @Override
    public Student delete(Integer s) {
        Student student = studentRepository.findById(s);
        /*student.setStatus(1);           //Usually we are not deleting data, so we can manage a status for deleted of not, 0 => not deleted, 1 => deleted
        studentRepository.save(student)*/
        studentRepository.delete(student);
        return student;
    }

    @Override
    public List<Student> index() {
        return studentRepository.findAll();
    }

    public Student findById(Integer s) {
        return studentRepository.findById(s);
    }
}
