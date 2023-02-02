package com.nicomarshal.portfolio.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Skill {
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
