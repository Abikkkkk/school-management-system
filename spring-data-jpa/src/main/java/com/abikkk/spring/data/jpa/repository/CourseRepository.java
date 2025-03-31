package com.abikkk.spring.data.jpa.repository;

import com.abikkk.spring.data.jpa.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface CourseRepository extends JpaRepository<Course,Long> {


    //@Modifying
    //@Query("DELETE FROM Course c WHERE c.courseTitle IS NULL")
    void deleteByCourseTitleIsNull();
}
