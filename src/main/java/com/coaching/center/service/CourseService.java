package com.coaching.center.service;

import com.coaching.center.model.Course;

public interface CourseService {
    String createCourse(Course course);

    Course getCourseById(String id);
}
