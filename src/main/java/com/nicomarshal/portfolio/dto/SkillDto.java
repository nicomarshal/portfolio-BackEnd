package com.nicomarshal.portfolio.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SkillDto {
    private String name;
    private int percentage;
    private Long personId;
    private Long skillTypeId;  
}
