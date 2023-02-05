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
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;
    private String username;
    private String password;
    private String email;
    
    //Bidirectional
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "role_id")
    private Role role;
    
    
}
