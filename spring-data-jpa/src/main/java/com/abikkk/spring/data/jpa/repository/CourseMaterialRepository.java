package com.abikkk.spring.data.jpa.repository;

import com.abikkk.spring.data.jpa.entity.CourseMaterialId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseMaterialRepository extends JpaRepository<CourseMaterialId,Long> {

    void deleteByUrlIsNull();
}
