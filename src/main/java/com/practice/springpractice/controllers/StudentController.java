package com.practice.springpractice.controllers;


import com.practice.springpractice.entity.Student;
import com.practice.springpractice.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")

public class StudentController {
    @Autowired
    private StudentService courseService;

    @PostMapping(value = "/addStudent")
    public Student addCourse(@RequestBody Student course) {

        return courseService.createStudent(course);
    }

    @GetMapping("/student/{id}")
    public Student getStudentById(@PathVariable Integer id) {
        return courseService.getStudentById(id);
    }

    @GetMapping("/students")
    public List<Student> getAllStudent() {
        return courseService.getStudents();
    }

    @GetMapping("/students/{courseId}")
    public List<Student> getAllStudentWithCourseId(@PathVariable Integer courseId) {
        return courseService.getStudentWithCourseId(courseId);
    }


    @PutMapping("/update-student")
    public Student updateStudent(@RequestBody Student course) {
        return courseService.updateStudent(course);
    }

    @DeleteMapping("/student/{id}")
    public String deleteStudent(@PathVariable int id) {
        return courseService.deleteStudentById(id);
    }
}
