package com.coaching.center.service.impl;

import com.coaching.center.model.Course;
import com.coaching.center.repository.impl.CourseRepositoryImpl;
import com.coaching.center.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepositoryImpl courseRepository;

    public String createCourse(Course course) {
        return courseRepository.createCourse(course);
    }

    @Override
    public Course findById(Long id) {
        return courseRepository.findById(id);
    }
}
