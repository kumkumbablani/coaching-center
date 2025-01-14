package com.coaching.center.service;

import com.coaching.center.entity.CourseEntity;
import com.coaching.center.model.Course;

import java.util.List;

public interface CourseService {
    Long createCourse(Course course);
    Course getCourseById(Long id);
    List<CourseEntity> getAllCourses();
    CourseEntity updateCourse(Long id , Course course);
    boolean deleteCourseById(Long id);

}
