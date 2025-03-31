//package com.abikkk.spring.data.jpa.repository;
//
//import com.abikkk.spring.data.jpa.entity.Guardian;
//import com.abikkk.spring.data.jpa.entity.Student;
//import jakarta.transaction.Transactional;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//@Transactional
//class StudentRepositoryTest {
//
//    @Autowired
//    private StudentRepository studentRepository;
//
//    @Test
//    public void addStudent(){
//        studentRepository.save(Student.builder().firstName("Richard").lastName("Parker").email("richardparker@yahoo.com").build());
//    }
//
//    @Test
//    public void addStudentWithGuardian(){
//        //using @Builder to create object.
//        Guardian guardian = Guardian.builder()
//                .guardianMobile("9999988888")
//                .guardianName("Ben")
//                .guardianEmail("ben@yahoo.com")
//                .build();
//
//        studentRepository.save(Student.builder().firstName("Richard").lastName("Parker").email("peterparker@gmail.com").guardian(guardian).build());
//    }
//
//}