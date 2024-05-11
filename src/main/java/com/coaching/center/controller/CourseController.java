package com.coaching.center.controller;

import com.coaching.center.model.Course;
import com.coaching.center.model.CourseOutput;
import com.coaching.center.service.CourseService;
import com.coaching.center.service.impl.CourseServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/course")
public class CourseController {

    CourseService courseService = new CourseServiceImpl();

    @GetMapping("{id}")
    public Course getCourseById(@PathVariable("id") String id) {
        return courseService.getCourseById(id);
    }

    @PostMapping
    public CourseOutput createCourse(@RequestBody Course course) {
        return courseService.createCourse(course);
    }


}
