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
public class Education {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)    
    private Long id;
    private String logo;
    private String instName;
    private String instDescription;
    private String career;
    private Date startDate;
    private Date finishDate;
    
    //Bidirectional
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "personId")
    private Person person;
    
    //Bidirectional
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "educationTypeId")
    private EducationType educationType; 
}
