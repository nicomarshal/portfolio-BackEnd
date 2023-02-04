package com.nicomarshal.portfolio.controller;

import com.nicomarshal.portfolio.model.User;
import com.nicomarshal.portfolio.service.IUserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    
    @Autowired
    private IUserService userService;
    
    @GetMapping("/user")
    @ResponseBody
    public List<User> getUsers() {
        return userService.getUsers();
    }
    
    @PostMapping("/user")
    public String createUser(@RequestBody User user){
        userService.saveUser(user);
        return "El usuario fue creado correctamente";
    }
    
    @PutMapping("/user/{id}")
    public String editUser(@PathVariable Long id,
                         @RequestParam String username,
                         @RequestParam String password,
                         @RequestParam String email){
        
        //Busco el user en cuestión
        User user = userService.findUser(id);
        
        //Esto tambien pude ir en service para desacoplar
        //mejor aun el codigo en un nuevo metodo
        user.setUsername(username);
        user.setPassword(password);
        user.setEMail(email);
        
        userService.saveUser(user);
        
        return "El usuario fue modificado correctamente";
    }    
    
    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return "El usuario fue eliminada correctamente";
    }
    
    @GetMapping("/user/{id}")
    @ResponseBody
    public User findUser(@PathVariable Long id) {
        return userService.findUser(id);
    }
}
