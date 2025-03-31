package com.abikkk.spring.data.jpa.repository;

import com.abikkk.spring.data.jpa.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    @Transactional
    @Modifying
    @Query("DELETE FROM Student s WHERE s.firstName IS NULL")//JPQL Query.
    void deleteAllByFirstNameIsNull();

    List<Student> findByFirstName(String firstName);

    List<Student> findByGuardianGuardianName(String guardianName);

    @Modifying
    @Query(
            value = "update student_table set email = ?2 where first_name=?1",
            nativeQuery = true
    )
    void updateStudentWithEmail(String firstName, String email);

}
