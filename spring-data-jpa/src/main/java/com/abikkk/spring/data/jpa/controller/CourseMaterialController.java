package com.abikkk.spring.data.jpa.controller;

import com.abikkk.spring.data.jpa.dto.CourseDTO;
import com.abikkk.spring.data.jpa.dto.CourseMaterialDTO;
import com.abikkk.spring.data.jpa.entity.CourseMaterialId;
import com.abikkk.spring.data.jpa.service.CourseMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course-material")
public class CourseMaterialController {

    @Autowired
    private CourseMaterialService courseMaterialService;

    @GetMapping("/all")
    public List<CourseMaterialDTO> getAllCourses(){
        return courseMaterialService.getAllCourses();
    }

    @PostMapping("/add-new")
    public CourseMaterialDTO addCourseMaterial(@RequestBody CourseMaterialId courseMaterial){
        return courseMaterialService.saveCourseMaterial(courseMaterial);
    }

    @DeleteMapping("/delete-null")
    public void deleteAllNullUrls(){
        courseMaterialService.deleteNullUrls();
    }

}
