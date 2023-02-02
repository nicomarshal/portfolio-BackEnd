package com.nicomarshal.portfolio.model;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Education {
    private Long id;
    private String logo;
    private String instName;
    private String instDescription;
    private String career;
    private Date startDate;
    private Date finishDate;
    
    //Foreign Key
    private Person personId;
    private EducationType typeId;

    public Education(String logo, String instName, String instDescription, String career, Date startDate, Date finishDate, Person personId, EducationType typeId) {
        this.logo = logo;
        this.instName = instName;
        this.instDescription = instDescription;
        this.career = career;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.personId = personId;
        this.typeId = typeId;
    }   
}
