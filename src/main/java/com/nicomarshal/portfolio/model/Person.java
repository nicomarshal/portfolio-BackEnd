package com.nicomarshal.portfolio.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Person {
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
