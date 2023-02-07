package com.nicomarshal.portfolio.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PersonDto {
    private String profileImg;
    private String name;
    private String surname;
    private String profession;
    private String aboutMe;
    private Long userId;  
}
