package com.abikkk.spring.data.jpa.service;

import com.abikkk.spring.data.jpa.entity.Course;
import com.abikkk.spring.data.jpa.entity.Teacher;
import com.abikkk.spring.data.jpa.repository.CourseRepository;
import com.abikkk.spring.data.jpa.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private CourseRepository courseRepository;

    public Teacher createTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }
//    {
//        "teacherName": "John Doe",
//            "courses": [
//        {
//            "courseTitle": "Mathematics",
//                "credits": 3
//        },
//        {
//            "courseTitle": "Physics",
//                "credits": 4
//        }
//    ]
//    }


    public Optional<Teacher> getTeacherById(Long id) {
        return teacherRepository.findById(id);
    }
}
