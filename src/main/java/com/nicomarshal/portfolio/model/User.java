package com.nicomarshal.portfolio.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    private String eMail;
    
    //Foreign Key
    private Role roleId;

    public User(String username, String password, String eMail, Role roleId) {
        this.username = username;
        this.password = password;
        this.eMail = eMail;
        this.roleId = roleId;
    }
}
