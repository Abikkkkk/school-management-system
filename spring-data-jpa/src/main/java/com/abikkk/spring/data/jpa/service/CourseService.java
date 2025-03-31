package com.abikkk.spring.data.jpa.service;

import com.abikkk.spring.data.jpa.dto.CourseDTO;
import com.abikkk.spring.data.jpa.entity.Course;
import com.abikkk.spring.data.jpa.repository.CourseRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private ModelMapper modelMapper;

    public CourseDTO saveCourse(Course course){
        courseRepository.save(course);
        return modelMapper.map(course,CourseDTO.class);
    }

    @Transactional
    public void deleteNullCourses() {
        courseRepository.deleteByCourseTitleIsNull();
    }

    //Get All courses.
    public List<CourseDTO> getAllCourses(){
        return courseRepository.findAll().stream()
                        .map(
                            course -> modelMapper.map(course, CourseDTO.class)
                            ).toList();
    }
}
