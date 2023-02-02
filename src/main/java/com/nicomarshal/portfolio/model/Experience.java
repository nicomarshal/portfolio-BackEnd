package com.nicomarshal.portfolio.model;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Experience {
    private Long id;
    private String logo;
    private String companyName;
    private String job;
    private Date startDate;
    private Date finishDate;
    private String description;
    
    //Foreign Key
    private Person personId;
    private ExperienceType typeId;

    public Experience(String logo, String companyName, String job, Date startDate, Date finishDate, String description, Person personId, ExperienceType typeId) {
        this.logo = logo;
        this.companyName = companyName;
        this.job = job;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.description = description;
        this.personId = personId;
        this.typeId = typeId;
    }

    
}
