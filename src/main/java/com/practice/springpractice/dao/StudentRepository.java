package com.practice.springpractice.dao;

import com.practice.springpractice.entity.Course;
import com.practice.springpractice.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query("FROM Student s where s.courseId=:courseId")
     List<Student> findByCourseId(Integer courseId);
}
