package com.nicomarshal.portfolio.controller;

import com.nicomarshal.portfolio.model.Role;
import com.nicomarshal.portfolio.service.IRoleService;
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
public class RoleController {
    
    @Autowired
    private IRoleService roleService;
    
    @GetMapping("/role")
    @ResponseBody
    public List<Role> getRoles() {
        return roleService.getRoles();
    }
    
    @PostMapping("/role")
    public String createRole(@RequestBody Role role){
        roleService.saveRole(role);
        return "El rol fue creado correctamente";
    }
    
    @PutMapping("/role/{id}")
    public String editRole(@PathVariable Long id,
                         @RequestParam String type,
                         @RequestParam String description){
        
        //Busco el role en cuestión
        Role role = roleService.findRole(id);
        
        //Esto tambien pude ir en service para desacoplar
        //mejor aun el codigo en un nuevo metodo
        role.setType(type);
        role.setDescription(description);
        
        roleService.saveRole(role);
        
        return "El rol fue modificado correctamente";
    }    
    
    @DeleteMapping("/role/{id}")
    public String deleteRole(@PathVariable Long id){
        roleService.deleteRole(id);
        return "El rol fue eliminado correctamente";
    }
    
    @GetMapping("/role/{id}")
    @ResponseBody
    public Role findRole(@PathVariable Long id) {
        return roleService.findRole(id);
    }
}
