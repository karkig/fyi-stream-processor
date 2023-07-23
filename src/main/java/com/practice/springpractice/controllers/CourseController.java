package com.practice.springpractice.controllers;


import com.practice.springpractice.entity.Course;
import com.practice.springpractice.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")

public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping(value = "/addCourse")
    public Course addCourse(@RequestBody Course course) {

        return courseService.createCourse(course);
    }

    @GetMapping("/course/{id}")
    public Course getCourseById(@PathVariable Integer id) {
        return courseService.getCourseById(id);
    }

    @GetMapping("/courses")
    public List<Course> getAllCourse() {
        return courseService.getCourses();
    }

    @PutMapping("/update-course")
    public Course updateCourse(@RequestBody Course course) {
        return courseService.updateCourse(course);
    }

    @DeleteMapping("/course/{id}")
    public String deleteCourse(@PathVariable int id) {
        return courseService.deleteCourseById(id);
    }
}
