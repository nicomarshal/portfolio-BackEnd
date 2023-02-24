package com.nicomarshal.portfolio.dto;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class EducationDto {  
    private String logo;
    private String instName;
    private String instDescription;
    private String career;
    private Date startDate;
    private Date finishDate;
    private Long personId;
    private Long educationTypeId;   
}
