package com.nicomarshal.portfolio.controller;

import com.nicomarshal.portfolio.dto.UserDto;
import com.nicomarshal.portfolio.service.IUserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    
    @Autowired
    private IUserService userService;
    
    @GetMapping("/user")
    @ResponseBody
    public List<UserDto> getUsers() {
        return userService.getUsers();
    }
    
    @PostMapping("/user")
    public String createUser(@RequestBody UserDto userDto){
        userService.createUser(userDto);
        return "El usuario fue creado correctamente";
    }
    
    @PutMapping("/user/{id}")
    public String editUser(@PathVariable Long id, @RequestBody UserDto userDto){
        
        userService.editUser(id, userDto);
        return "El usuario fue modificado correctamente";
    }    
    
    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return "El usuario fue eliminada correctamente";
    }
    
    @GetMapping("/user/{id}")
    @ResponseBody
    public UserDto findUser(@PathVariable Long id) {
        return userService.findUser(id);
    }
}
