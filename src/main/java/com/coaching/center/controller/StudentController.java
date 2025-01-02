package com.coaching.center.controller;

import com.coaching.center.entity.StudentEntity;
import com.coaching.center.model.Student;
import com.coaching.center.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<Long> registerStudent(@RequestBody Student student){
        return new ResponseEntity<>(studentService.registerStudent(student) , HttpStatus.CREATED);
    }

    @GetMapping
    public List<StudentEntity> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") Long id){
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

}
