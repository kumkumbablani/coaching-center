package com.coaching.center.validator;

import com.coaching.center.exception.MissingMandatoryFieldException;
import com.coaching.center.model.Course;
import com.coaching.center.model.Student;
import io.micrometer.common.util.StringUtils;
import lombok.experimental.UtilityClass;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.coaching.center.util.Message.*;

@UtilityClass
public class Validator {
    public static void validateCourse(Course course) {
        List<String> errors = new ArrayList<>();
        if (StringUtils.isEmpty(course.getName()))
            errors.add(MSG_EMPTY_COURSE_NAME);
        if (StringUtils.isEmpty(course.getDescription()))
            errors.add(MSG_EMPTY_COURSE_DESC);
        if (!errors.isEmpty())
            throw new MissingMandatoryFieldException("Mandatory fields are missing", errors);
    }

    public static void validateStudent(Student student) {
        List<String> errors = new ArrayList<>();
        if (StringUtils.isBlank(student.getFullName()))
            errors.add(MSG_EMPTY_STUDENT_NAME);
        if (StringUtils.isBlank(student.getEmail()))
            errors.add(MSG_EMPTY_STUDENT_EMAIL);
        if (student.getDateOfBirth() == null)
            errors.add(MSG_EMPTY_STUDENT_DOB);
        else if (student.getDateOfBirth().isAfter(LocalDate.now()))
            errors.add(MSG_INVALID_STUDENT_DOB);
        if (StringUtils.isBlank(student.getContactNumber()))
            errors.add(MSG_EMPTY_CONTACT_NUMBER);
        else if (student.getContactNumber().length() != 10)
            errors.add(MSG_INVALID_CONTACT_NUMBER);
        if (student.getStudentId() == null || student.getStudentId() <= 0)
            errors.add(MSG_INVALID_COURSE_ID);
        if (StringUtils.isBlank(student.getAddress()))
            errors.add(MSG_EMPTY_STUDENT_ADDRESS);
        if (!errors.isEmpty())
            throw new MissingMandatoryFieldException("Mandatory fields are missing", errors);
    }

}

