package com.nicomarshal.portfolio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Skill {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private int percentage;
    
    //Foreign Key
    private Person personId;
    private SkillType typeId;

    public Skill(String name, int percentage, Person personId, SkillType typeId) {
        this.name = name;
        this.percentage = percentage;
        this.personId = personId;
        this.typeId = typeId;
    }

    
}
