package com.abikkk.spring.data.jpa.controller;

import com.abikkk.spring.data.jpa.dto.CourseDTO;
import com.abikkk.spring.data.jpa.entity.Course;
import com.abikkk.spring.data.jpa.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping("/save-course")
    public ResponseEntity<CourseDTO> saveCourse(@RequestBody Course course){
        return new ResponseEntity<>(courseService.saveCourse(course), HttpStatus.OK);
    }

    @DeleteMapping("/delete-null")
    public void deleteNullCourses(){
        courseService.deleteNullCourses();
    }

    @GetMapping("/all-courses")
    public List<CourseDTO> getAllCourses(){
        return courseService.getAllCourses();
    }

}
