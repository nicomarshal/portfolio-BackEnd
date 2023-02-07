package com.nicomarshal.portfolio.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserDto {
    private String username;
    private String password;
    private String email;
    private Long roleId;
}
