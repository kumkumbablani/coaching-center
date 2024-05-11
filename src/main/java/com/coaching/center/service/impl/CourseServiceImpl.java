package com.coaching.center.service.impl;

import com.coaching.center.model.Course;
import com.coaching.center.model.CourseOutput;
import com.coaching.center.repository.impl.CourseRepositoryImpl;
import com.coaching.center.service.CourseService;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

    // all business logics to be handled only in service layer
    CourseRepositoryImpl courseRepository = new CourseRepositoryImpl();
    public Course getCourseById(String id) {
        return courseRepository.getCourseById();
        // business logic
    }

    public CourseOutput createCourse(Course course) {
        return courseRepository.createCourse(course);
    }
}
