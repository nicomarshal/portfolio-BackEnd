package com.nicomarshal.portfolio.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;
    private String type;
    private String description;
    
    //Bidirectional
    @OneToMany (cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "role")
    private List<User> listUsers;
}
