package com.nicomarshal.portfolio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    
    //Foreign Key
    private User userId;

    public Person(String profileImg, String name, String surname, String profession, String aboutMe, User userId) {
        this.profileImg = profileImg;
        this.name = name;
        this.surname = surname;
        this.profession = profession;
        this.aboutMe = aboutMe;
        this.userId = userId;
    }
}
