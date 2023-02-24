package com.nicomarshal.portfolio.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;
    private String profileImg;
    private String name;
    private String surname;
    private String profession;
    private String aboutMe;
    
    // Unidirectional
    /*Creamos una clave foránea (FK), llamada "userId" en la tabla Person, la cual será
    una referencia a la clave primaria (PK) de la tabla User, llamada en este caso "id"*/
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId", referencedColumnName = "id")
    private User user;
    
    //Bidirectional
    @OneToMany (cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "person")
    private List<Experience> listExperiences;

    //Bidirectional
    @OneToMany (cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "person")
    private List<Education> listEducation;   
    
    //Bidirectional
    @OneToMany (cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "person")
    private List<Skill> listSkills;
    
    //Bidirectional
    @OneToMany (cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "person")
    private List<Project> listProjects;

    public Person() {
    }

    public Person(Long id, String profileImg, String name, String surname, String profession, String aboutMe, User user, List<Experience> listExperiences, List<Education> listEducation, List<Skill> listSkills, List<Project> listProjects) {
        this.id = id;
        this.profileImg = profileImg;
        this.name = name;
        this.surname = surname;
        this.profession = profession;
        this.aboutMe = aboutMe;
        this.user = user;
        this.listExperiences = listExperiences;
        this.listEducation = listEducation;
        this.listSkills = listSkills;
        this.listProjects = listProjects;
    }
}
