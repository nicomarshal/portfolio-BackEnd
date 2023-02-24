package com.nicomarshal.portfolio.service;

import com.nicomarshal.portfolio.dto.UserDto;
import java.util.List;

public interface IUserService {
    public List<UserDto> getUsers();
    
    public void createUser(UserDto userDto);
    
    public void editUser(Long id, UserDto userDto);
    
    public void deleteUser(Long id);
    
    public UserDto findUser(Long id);    
}
