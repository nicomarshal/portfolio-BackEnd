package com.nicomarshal.portfolio.dto;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProjectDto {
    private String name;
    private String description;
    private Date startDate;
    private Date finishDate;
    private String images;
    private String url;
    private Long personId;    
}
