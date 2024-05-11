package com.coaching.center.repository;

import com.coaching.center.model.Course;
import com.coaching.center.model.CourseOutput;

public interface CourseRepository {
    Course getCourseById();

    CourseOutput createCourse(Course course);
}
