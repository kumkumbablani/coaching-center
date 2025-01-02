package com.coaching.center.controller;

import com.coaching.center.entity.CourseEntity;
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

    @PostMapping
    public ResponseEntity<Long> createCourse(@RequestBody Course course) {
        return new ResponseEntity<>(courseService.createCourse(course), HttpStatus.CREATED);
    }

    @GetMapping
    public List<CourseEntity> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(courseService.getCourseById(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCourseById(@PathVariable("id") Long id) {
        boolean isDeleted = courseService.deleteCourseById(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<CourseEntity> updateCourse(@PathVariable Long id , @RequestBody Course course){
        return ResponseEntity.ok(courseService.updateCourse(id , course));
    }

}
