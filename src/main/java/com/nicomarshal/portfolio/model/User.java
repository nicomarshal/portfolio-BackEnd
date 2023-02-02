package com.nicomarshal.portfolio.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class User {
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
