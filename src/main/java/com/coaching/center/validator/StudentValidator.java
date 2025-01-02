package com.coaching.center.validator;

import com.coaching.center.entity.StudentEntity;
import com.coaching.center.exception.DuplicateStudentException;
import com.coaching.center.exception.MissingMandatoryFieldException;
import lombok.experimental.UtilityClass;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class StudentValidator {
    public void validateDuplicateStudentName(String fullName, List<StudentEntity> existingStudents) {
        if (existingStudents.stream().anyMatch(s -> s.getFullName() != null && s.getFullName().equalsIgnoreCase(fullName))) {
            throw new DuplicateStudentException("Student with name " + fullName + " already exists");
        }
    }
}
