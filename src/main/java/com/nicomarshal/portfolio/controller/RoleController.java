package com.nicomarshal.portfolio.controller;

import com.nicomarshal.portfolio.dto.RoleDto;
import com.nicomarshal.portfolio.service.IRoleService;
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
public class RoleController {
    
    @Autowired
    private IRoleService roleService;
    
    @GetMapping("/role")
    @ResponseBody
    public List<RoleDto> getRoles() {
        return roleService.getRoles();
    }
    
    @PostMapping("/role")
    public String createRole(@RequestBody RoleDto roleDto){
        roleService.createRole(roleDto);
        return "El usuario fue creado correctamente";
    }
    
    @PutMapping("/role/{id}")
    public String editRole(@PathVariable Long id, @RequestBody RoleDto roleDto){
        
        roleService.editRole(id, roleDto);
        return "El usuario fue modificado correctamente";
    }    
    
    @DeleteMapping("/role/{id}")
    public String deleteRole(@PathVariable Long id){
        roleService.deleteRole(id);
        return "El rol fue eliminado correctamente";
    }
    
    @GetMapping("/role/{id}")
    @ResponseBody
    public RoleDto findRole(@PathVariable Long id) {
        return roleService.findRole(id);
    }
}
