package com.practice.springpractice.services;


import com.practice.springpractice.dao.CourseRepository;
import com.practice.springpractice.entity.Course;
import com.practice.springpractice.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }


    public Course getCourseById(Integer id) {
        return courseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public List<Course> getCourses() {
        return courseRepository.findAll();
    }

    public Course updateCourse(Course course) {
        Course oldCourse = courseRepository.findById(course.getId()).orElseThrow(() -> new ResourceNotFoundException(course.getId()));
        oldCourse.setName(course.getName());
        courseRepository.save(oldCourse);
        return oldCourse;
    }

    public String deleteCourseById(int id) {
        courseRepository.deleteById(id);
        return "Course got deleted";
    }

}
