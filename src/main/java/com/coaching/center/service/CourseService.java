package com.coaching.center.service;

import com.coaching.center.model.Course;
import com.coaching.center.model.CourseOutput;

public interface CourseService {
    Course getCourseById(String id);

    CourseOutput createCourse(Course course);
}
