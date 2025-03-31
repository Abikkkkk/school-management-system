package com.abikkk.spring.data.jpa.service;


import com.abikkk.spring.data.jpa.dto.CourseDTO;
import com.abikkk.spring.data.jpa.dto.CourseMaterialDTO;
import com.abikkk.spring.data.jpa.entity.CourseMaterialId;
import com.abikkk.spring.data.jpa.repository.CourseMaterialRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Map;

@Service
public class CourseMaterialService {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Autowired
    private ModelMapper modelMapper;
    //get all CourseMaterials.
    public List<CourseMaterialDTO> getAllCourses(){
        return courseMaterialRepository.findAll().stream()
                .map(
                        course -> modelMapper.map(course, CourseMaterialDTO.class)
                ).toList();
    }
    //add a CourseMaterial.
    public CourseMaterialDTO saveCourseMaterial(CourseMaterialId courseMaterial) {
        return modelMapper.map(courseMaterialRepository.save(courseMaterial),CourseMaterialDTO.class);
    }
    //Delete null url entries.
    @Transactional
    public void deleteNullUrls(){
        courseMaterialRepository.deleteByUrlIsNull();
    }
}
