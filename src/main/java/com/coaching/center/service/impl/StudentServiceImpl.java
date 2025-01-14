package com.coaching.center.service.impl;

import com.coaching.center.converter.StudentConverter;
import com.coaching.center.entity.StudentEntity;
import com.coaching.center.exception.DuplicateStudentException;
import com.coaching.center.exception.StudentNotFoundException;
import com.coaching.center.model.Student;
import com.coaching.center.model.UpdateStudentModel;
import com.coaching.center.repository.StudentRepository;
import com.coaching.center.service.StudentService;
import com.coaching.center.validator.Validator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Long registerStudent(Student student) {
        Validator.validateStudent(student);
        Validator.validateDuplicateStudentEmail(student.getEmail() , studentRepository.findAll());
        StudentEntity studentEntity = StudentConverter.convert(student);
        studentEntity.setRegistrationDate(LocalDateTime.now());
        return studentRepository.save(studentEntity).getId();
    }

    @Override
    public List<Student> getAllStudents() {
        return StudentConverter.convert(studentRepository.findAll());
    }

    @Override
    public Student getStudentById(Long id) {
        Optional<StudentEntity> studentEntityOptional = studentRepository.findById(id);
        if(studentEntityOptional.isPresent())
            return StudentConverter.convert(studentEntityOptional.get());
        else throw new StudentNotFoundException("The student with id: " + id + " does not exists");
    }

    @Override
    public Student getStudentByEmail(String email) {
        Optional<StudentEntity> studentEntity = studentRepository.findByEmail(email);
        if (studentEntity.isPresent()){
            throw new DuplicateStudentException("Student with email " + email + " already exists.");
        }
        return StudentConverter.convert(studentEntity.get());
    }

    @Override
    public Student updateStudent(Long id, UpdateStudentModel student) {
        StudentEntity existingstudentEntity = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with id : "));

        if(StringUtils.isNotEmpty(student.getName()))
            existingstudentEntity.setName(student.getName());
        if(StringUtils.isNotEmpty(student.getAddress()))
            existingstudentEntity.setAddress(student.getAddress());
        if(StringUtils.isNotEmpty(student.getEmail()))
            existingstudentEntity.setName(student.getEmail());
        if(StringUtils.isNotEmpty(student.getContactNumber()))
            existingstudentEntity.setAddress(student.getContactNumber());
        return StudentConverter.convert(studentRepository.save(existingstudentEntity));
    }

    @Override
    public void deleteStudentById(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new StudentNotFoundException("Student not found with id: " + id);
        }
        studentRepository.deleteById(id);
    }
}
