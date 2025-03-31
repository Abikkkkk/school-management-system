package com.abikkk.spring.data.jpa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseMaterialDTO {
    private Long courseMaterialId;
    private String url;
}