package com.coaching.center.validator;

import com.coaching.center.entity.StudentEntity;
import com.coaching.center.exception.DuplicateStudentException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StudentValidator {
    public void validateDuplicateStudentName(String fullName, List<StudentEntity> existingStudents) {
        if (existingStudents.stream().anyMatch(s -> s.getFullName() != null && s.getFullName().equalsIgnoreCase(fullName))) {
            throw new DuplicateStudentException("Student with name " + fullName + " already exists");
        }
    }
}
