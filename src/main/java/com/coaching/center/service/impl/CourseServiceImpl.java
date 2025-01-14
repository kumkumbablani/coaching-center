package com.coaching.center.service.impl;

import com.coaching.center.converter.CourseConverter;
import com.coaching.center.entity.CourseEntity;
import com.coaching.center.exception.CourseNotFoundException;
import com.coaching.center.exception.DuplicateStudentException;
import com.coaching.center.model.Course;
import com.coaching.center.repository.CourseRepository;
import com.coaching.center.service.CourseService;
import com.coaching.center.validator.CourseValidator;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;
    private List<CourseEntity> existingCourses;
    public Long createCourse(Course course) {
        CourseValidator.validateCourse(course);
        validateDuplicateCourseName(course.getName(), courseRepository.findAll());
        return courseRepository.save(CourseConverter.convert(course)).getId();
    }

    @Override
    public Course getCourseById(Long id) {
        Optional<CourseEntity> courseEntityOptional = courseRepository.findById(id);
        if(courseEntityOptional.isPresent())
            return CourseConverter.convert(courseEntityOptional.get());
        else throw new CourseNotFoundException("The course with id: " + id + " does not exists");
    }

    @Override
    public List<CourseEntity> getAllCourses() {
        List<CourseEntity> courseList = courseRepository.findAll();
        System.out.println("Course List: " + courseList);  // Debug log
        return courseList;
    }

    @Override
    public CourseEntity updateCourse(Long id, Course course) {

        CourseEntity existingCourseEntity = courseRepository.findById(id)
                .orElseThrow(() -> new CourseNotFoundException("Course not found with id : " + id));

        existingCourseEntity.setName(course.getName());
        existingCourseEntity.setDescription(course.getDescription());

        CourseEntity updatedCourseEntity = courseRepository.save(existingCourseEntity);
        return updatedCourseEntity;
    }

    @Override
    public boolean deleteCourseById(Long id) {
        if (!courseRepository.existsById(id)) {
            throw new CourseNotFoundException("Course not found with id: " + id);
        }
        courseRepository.deleteById(id);
        return false;
    }

    private void validateDuplicateCourseName(String courseName, List<CourseEntity> existingCourses) {
        if(existingCourses.stream().anyMatch(c -> c.getName()!= null && c.getName().equalsIgnoreCase(courseName)))
            throw new DuplicateStudentException("Course with name "+ courseName + " already exists");
    }
}
