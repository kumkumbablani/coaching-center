package com.coaching.center.repository.impl;

import com.coaching.center.model.Course;
import com.coaching.center.model.CourseOutput;
import com.coaching.center.repository.CourseRepository;
import org.springframework.stereotype.Repository;

@Repository
public class CourseRepositoryImpl implements CourseRepository {

    // database related work

    public Course getCourseById() {
        return new Course();
    }

    public CourseOutput createCourse(Course course) {
        CourseOutput courseOutput = new CourseOutput();
        courseOutput.setId(course.getId());
        return courseOutput;
    }
}
