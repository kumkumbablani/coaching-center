package com.coaching.center.repository.impl;

import com.coaching.center.model.Course;
import com.coaching.center.repository.CourseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CourseRepositoryImpl implements CourseRepository {

    @Override
    public Course save(Course course) {
        return null;
    }

    @Override
    public List<Course> findAll() {
        return null;
    }

    public String createCourse(Course course) {
        return course.getId();
    }

    @Override
    public Course findById(Long id) {
        return null;
    }

    public Course getCourseById() {
        return Course.builder()
                .name("test")
                .description("test")
                .build();
    }

}