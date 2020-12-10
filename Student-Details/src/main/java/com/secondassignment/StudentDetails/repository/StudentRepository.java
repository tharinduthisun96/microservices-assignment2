package com.secondassignment.StudentDetails.repository;

import com.secondassignment.StudentDetails.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, String> {
    Student deleteById(Integer s);
    Student findById(Integer s);
}
