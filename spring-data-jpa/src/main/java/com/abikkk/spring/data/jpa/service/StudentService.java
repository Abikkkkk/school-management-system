package com.abikkk.spring.data.jpa.service;

import com.abikkk.spring.data.jpa.entity.Guardian;
import com.abikkk.spring.data.jpa.entity.Student;
import com.abikkk.spring.data.jpa.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    //save a student
    public void saveStudent(Student student){
        studentRepository.save(student);
    }

    //save a student with guardian details
    public void saveStudentWithGuardian(Student student, Guardian guardian){
        student.setGuardian(guardian);
        studentRepository.save(student);
    }

    //delete records where firstName is null.
    public void deleteAllNullFirstNames(){
        studentRepository.deleteAllByFirstNameIsNull();
    }

    //get Student by firstName.
    public List<Student> getStudentByFirstName(String firstName){
        return studentRepository.findByFirstName(firstName);
    }

    //get Student by guardianName.
    public List<Student> getStudentByGuardianName(String guardianName){
        return studentRepository.findByGuardianGuardianName(guardianName);
    }

    //update Student email with firstName.
    @Transactional
    public void updateEmailWithFirstName(String firstName, String lastName){
        studentRepository.updateStudentWithEmail(firstName,lastName);
    }
}
