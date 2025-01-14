package com.coaching.center.converter;

import com.coaching.center.entity.StudentEntity;
import com.coaching.center.model.Student;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class StudentConverter {

    public static StudentEntity convert(Student student) {
        return StudentEntity.builder()
                .name(student.getName())
                .dateOfBirth(student.getDateOfBirth())
                .contactNumber(student.getContactNumber())
                .email(student.getEmail())
                .address(student.getAddress())
                .build();
    }

    public static Student convert(StudentEntity studentEntity) {
        return Student.builder()
                .id(studentEntity.getId())
                .name(studentEntity.getName())
                .dateOfBirth(studentEntity.getDateOfBirth())
                .contactNumber(studentEntity.getContactNumber())
                .email(studentEntity.getEmail())
                .address(studentEntity.getAddress())
                .build();
    }

    public static List<Student> convert(List<StudentEntity> studentEntityList) {
        List<Student> students = new ArrayList<>(studentEntityList.size());
        studentEntityList.forEach(studentEntity -> {
            students.add(Student.builder()
                            .id(studentEntity.getId())
                            .name(studentEntity.getName())
                            .dateOfBirth(studentEntity.getDateOfBirth())
                            .contactNumber(studentEntity.getContactNumber())
                            .email(studentEntity.getEmail())
                            .address(studentEntity.getAddress())
                    .build());
        });
        return students;
    }
}
