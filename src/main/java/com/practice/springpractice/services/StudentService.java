package com.practice.springpractice.services;


import com.practice.springpractice.dao.StudentRepository;
import com.practice.springpractice.entity.Student;
import com.practice.springpractice.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student createStudent(Student course) {
        return studentRepository.save(course);
    }


    public Student getStudentById(Integer id) {
        return studentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }
    public List<Student> getStudentWithCourseId(Integer courseId) {
        return studentRepository.findByCourseId(courseId);
    }
    public Student updateStudent(Student student) {
        Student oldCourse = studentRepository.findById(student.getId()).orElseThrow(() -> new ResourceNotFoundException(student.getId()));
        oldCourse.setAddress(student.getAddress());
        oldCourse.setEmail(student.getEmail());
        oldCourse.setCourseId(student.getCourseId());
        oldCourse.setName(student.getName());
        studentRepository.save(oldCourse);
        return oldCourse;

    }

    public String deleteStudentById(int id) {
        studentRepository.deleteById(id);
        return "Course got deleted";
    }

}
