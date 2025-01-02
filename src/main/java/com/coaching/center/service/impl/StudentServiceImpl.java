package com.coaching.center.service.impl;

import com.coaching.center.converter.StudentConverter;
import com.coaching.center.entity.StudentEntity;
import com.coaching.center.exception.CourseNotFoundException;
import com.coaching.center.exception.DuplicateStudentException;
import com.coaching.center.exception.StudentNotFoundException;
import com.coaching.center.model.Student;
import com.coaching.center.repository.StudentRepository;
import com.coaching.center.service.StudentService;
import com.coaching.center.validator.StudentValidator;
import com.coaching.center.validator.Validator;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;

    private List<StudentEntity> existingStudents;
    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Long registerStudent(Student student) {
       Validator.validateStudent(student);
       validateDuplicateStudentName(student.getFullName() , existingStudents);
       return studentRepository.save(StudentConverter.convert(student)).getStudentId();
    }

    @Override
    public List<StudentEntity> getAllStudents() {
        return studentRepository.findAll();
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
        Student student = studentRepository.findByEmail(email);

        if (student != null){
            throw new DuplicateStudentException("Student with email " + email + " already exists.");
        }

        return student;
    }

    @Override
    public StudentEntity updateStudent(Long id, Student student) {
        StudentEntity existingstudentEntity = (StudentEntity) studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with id : " + id));

        existingstudentEntity.setFullName(student.getFullName());
        existingstudentEntity.setDateOfBirth(student.getDateOfBirth());
        existingstudentEntity.setEmail(student.getEmail());
        existingstudentEntity.setAddress(student.getAddress());

        StudentEntity updatedStudentEntity = (StudentEntity) studentRepository.save(existingstudentEntity);
        return updatedStudentEntity;
    }

    @Override
    public boolean deleteStudentById(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new CourseNotFoundException("Course not found with id: " + id);
        }
        studentRepository.deleteById(id);
        return false;
    }

    public void validateDuplicateStudentName(String fullName, List<StudentEntity> existingStudents) {
        if (existingStudents.stream().anyMatch(s -> s.getFullName() != null && s.getFullName().equalsIgnoreCase(fullName))) {
            throw new DuplicateStudentException("Student with name " + fullName + " already exists");
        }
    }
}
