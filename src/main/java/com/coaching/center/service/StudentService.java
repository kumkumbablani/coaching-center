package com.coaching.center.service;

import com.coaching.center.entity.StudentEntity;
import com.coaching.center.model.Student;

import java.util.List;

public interface StudentService {

    Long registerStudent(Student student);

    List<StudentEntity> getAllStudents();

    Student getStudentById(Long id);

    Student getStudentByEmail(String email);

    StudentEntity updateStudent(Long id , Student student) throws Throwable;

    boolean deleteStudentById(Long id);
}
