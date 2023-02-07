package com.nicomarshal.portfolio.service;

import com.nicomarshal.portfolio.model.Role;
import com.nicomarshal.portfolio.dto.UserDto;
import com.nicomarshal.portfolio.model.User;
import com.nicomarshal.portfolio.repository.IRoleRepository;
import com.nicomarshal.portfolio.repository.IUserRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private IRoleRepository roleRepository;

    @Override
    public List<UserDto> getUsers() {
        List<User> listUsers = userRepository.findAll();
        
        List<UserDto> listUsersDto = new ArrayList<>();
        
        for (User user : listUsers) {
            UserDto userDto = new UserDto();
            
            //Mapeo
            userDto.setUsername(user.getUsername());
            userDto.setPassword(user.getPassword());
            userDto.setEmail(user.getEmail());
            userDto.setRoleId(user.getRole().getId());
            
            listUsersDto.add(userDto);
        }       
        return listUsersDto;
    }

    @Override
    public void createUser(UserDto userDto) {
        Long roleId = userDto.getRoleId();     
        Role role = roleRepository.findById(roleId).orElse(null);
        
        User user = new User();
        
        //Mapeo
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        user.setRole(role);
        
        userRepository.save(user);
    }
    
    @Override
    public void editUser(Long id, UserDto userDto) {
        Long roleId = userDto.getRoleId();     
        Role role = roleRepository.findById(roleId).orElse(null);
        
        User user = userRepository.findById(id).orElse(null);
        
        //Mapeo
        user.setUsername(userDto.getUsername());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        user.setRole(role);
        
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDto findUser(Long id) {
        User user = userRepository.findById(id).orElse(null);
        
        UserDto userDto = new UserDto();
        
        //Mapeo
        userDto.setUsername(user.getUsername());
        userDto.setPassword(user.getPassword());
        userDto.setEmail(user.getEmail());
        userDto.setRoleId(user.getRole().getId());
        
        return userDto;
    }   
}
