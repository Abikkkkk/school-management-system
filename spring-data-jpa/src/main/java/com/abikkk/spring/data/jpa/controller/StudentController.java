package com.abikkk.spring.data.jpa.controller;


import com.abikkk.spring.data.jpa.dto.StudentWithGuardianRequest;
import com.abikkk.spring.data.jpa.entity.Student;
import com.abikkk.spring.data.jpa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/school")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/save-student")
    public void saveStudent(@RequestBody Student student){
        studentService.saveStudent(student);
    }

    @PostMapping("/save-student-with-guardian")
    public ResponseEntity<String> saveStudentWithGuardianName(@RequestBody StudentWithGuardianRequest request){
        studentService.saveStudentWithGuardian(request.getStudent(), request.getGuardian());
        return ResponseEntity.ok("Student with guardian saved successfully!");
    }

    @DeleteMapping("/null-firstNames")
    public void deleteAllWithNullFirstNames(){
        studentService.deleteAllNullFirstNames();
    }

    @GetMapping("/get-student/first-name/{firstName}")
    public ResponseEntity<List<Student>> getStudentByFirstName(@PathVariable String firstName){
        return new ResponseEntity<>(studentService.getStudentByFirstName(firstName), HttpStatus.OK);
    }

    @GetMapping("/get-student/guardian-name/{guardianName}")
    public ResponseEntity<List<Student>> getStudentByGuardianName(@PathVariable String guardianName){
        return new ResponseEntity<>(studentService.getStudentByGuardianName(guardianName), HttpStatus.OK);
    }

//    @PutMapping("/update-email/firstName/{firstName}")
//    public ResponseEntity<String> updateStudentNameWithEmail(@PathVariable String firstName, @RequestBody String email){
//        studentService.updateEmailWithFirstName(firstName,email);
//        return new ResponseEntity<>("Email Updated Successfully",HttpStatus.OK);
//    }

    @PutMapping("/update-email/first-name/{firstName}")
    public ResponseEntity<String> updateStudentNameWithEmail(
            @PathVariable String firstName,
            @RequestBody Map<String, String> requestBody) {         //you can use aa dto instead of using this Map method.

        String email = requestBody.get("email");
        studentService.updateEmailWithFirstName(firstName, email);

        return ResponseEntity.ok("Email Updated Successfully");
    }

}
