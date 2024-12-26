package com.coaching.center.repository;

import com.coaching.center.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository{
    Course save(Course course);
    List<Course> findAll();
    String createCourse(Course course);
    Course findById(Long id);
}
