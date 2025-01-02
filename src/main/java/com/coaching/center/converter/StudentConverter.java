package com.coaching.center.converter;

import com.coaching.center.entity.CourseEntity;
import com.coaching.center.entity.StudentEntity;
import com.coaching.center.model.Course;
import com.coaching.center.model.Student;
import lombok.experimental.UtilityClass;

@UtilityClass
public class StudentConverter {

    public static StudentEntity convert(Student student) {
        return StudentEntity.builder()
                .fullName(student.getFullName())
                .dateOfBirth(student.getDateOfBirth())
                .contactNumber(student.getContactNumber())
                .email(student.getEmail())
                .address(student.getAddress())
                .build();
    }

    public static Student convert(StudentEntity studentEntity) {
        return Student.builder()
                .studentId(studentEntity.getStudentId())
                .fullName(studentEntity.getFullName())
                .dateOfBirth(studentEntity.getDateOfBirth())
                .contactNumber(studentEntity.getContactNumber())
                .email(studentEntity.getEmail())
                .address(studentEntity.getAddress())
                .build();
    }


}
