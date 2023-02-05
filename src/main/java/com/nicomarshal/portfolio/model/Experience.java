package com.nicomarshal.portfolio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Experience {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)    
    private Long id;
    private String logo;
    private String companyName;
    private String job;
    private Date startDate;
    private Date finishDate;
    private String description;
    
    //Bidirectional
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "personId")
    private Person person;
    
    //Bidirectional
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "experienceTypeId")
    private ExperienceType experienceType;

    public Experience(Long id, String logo, String companyName, String job, Date startDate, Date finishDate, String description, Person person, ExperienceType experienceType) {
        this.id = id;
        this.logo = logo;
        this.companyName = companyName;
        this.job = job;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.description = description;
        this.person = person;
        this.experienceType = experienceType;
    }
}