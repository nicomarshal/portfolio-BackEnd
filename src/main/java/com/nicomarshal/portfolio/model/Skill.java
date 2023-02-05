package com.nicomarshal.portfolio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

    //Bidirectional
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "personId")
    private Person person;
    
    //Bidirectional
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "skillTypeId")  
    private SkillType skillType;

    public Skill(Long id, String name, int percentage, Person person, SkillType skillType) {
        this.id = id;
        this.name = name;
        this.percentage = percentage;
        this.person = person;
        this.skillType = skillType;
    }
}
