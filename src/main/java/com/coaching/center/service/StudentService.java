package com.coaching.center.service;

import com.coaching.center.entity.StudentEntity;
import com.coaching.center.model.Student;
import com.coaching.center.model.UpdateStudentModel;

import java.util.List;

public interface StudentService {
    Long registerStudent(Student student);
    List<Student> getAllStudents();
    Student getStudentById(Long id);
    Student getStudentByEmail(String email);
    Student updateStudent(Long id, UpdateStudentModel student);
    void deleteStudentById(Long id);
}
