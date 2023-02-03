package com.nicomarshal.portfolio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Project {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String description;
    private Date startDate;
    private Date finishDate;
    private String images;
    private String url;
    
    //Foreign Key
    private Person personId;

    public Project(String name, String description, Date startDate, Date finishDate, String images, String url, Person personId) {
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.images = images;
        this.url = url;
        this.personId = personId;
    }    
}
