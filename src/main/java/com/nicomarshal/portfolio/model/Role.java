package com.nicomarshal.portfolio.model;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Role {
    private Long id;
    private String type;
    private String description;

    public Role() {
    }
}
