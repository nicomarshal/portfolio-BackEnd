package com.nicomarshal.portfolio.dto;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ExperienceDto {
    private String logo;
    private String companyName;
    private String job;
    private Date startDate;
    private Date finishDate;
    private String description;
    private Long personId;
    private Long experienceTypeId;  
}
