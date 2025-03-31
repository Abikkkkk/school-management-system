package com.abikkk.spring.data.jpa.dto;

import com.abikkk.spring.data.jpa.entity.Guardian;
import com.abikkk.spring.data.jpa.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentWithGuardianRequest {
    //custom request for adding both Student and Guardian.
    private Student student;
    private Guardian guardian;
}