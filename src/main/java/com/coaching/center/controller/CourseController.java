package com.coaching.center.controller;

import com.coaching.center.model.Course;
import com.coaching.center.repository.CourseRepository;
import com.coaching.center.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @Autowired
    private CourseRepository courseRepository;
    @PostMapping
    public ResponseEntity<String> createCourse(@RequestBody Course course) {
        return new ResponseEntity<>(courseService.createCourse(course), HttpStatus.CREATED);
    }

    @GetMapping
    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }
    @GetMapping("{id}")
    public Course getCourseById(@PathVariable("id") String id) {
        return courseService.getCourseById(id);
    }



}
