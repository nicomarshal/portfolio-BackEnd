package com.nicomarshal.portfolio.service;

import com.nicomarshal.portfolio.dto.RoleDto;
import com.nicomarshal.portfolio.model.Role;
import com.nicomarshal.portfolio.repository.IRoleRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService implements IRoleService {
    @Autowired
    private IRoleRepository roleRepository;

    @Override
    public List<RoleDto> getRoles() {
        List<Role> listRoles = roleRepository.findAll();
        
        List<RoleDto> listRolesDto = new ArrayList<>();
        
        for (Role role : listRoles) {
            RoleDto roleDto = new RoleDto();
            
            //Mapeo
            roleDto.setType(role.getType());
            roleDto.setDescription(role.getDescription());
            
            listRolesDto.add(roleDto);
        }       
        return listRolesDto;
    }

    @Override
    public void createRole(RoleDto roleDto) {
        Role role = new Role();
        
        role.setType(roleDto.getType());
        role.setDescription(roleDto.getDescription());
        
        roleRepository.save(role);
    }
    
    @Override
    public void editRole(Long id, RoleDto roleDto) {        
        Role role = roleRepository.findById(id).orElse(null);
        
        //Mapeo
        role.setType(roleDto.getType());
        role.setDescription(roleDto.getDescription());

        roleRepository.save(role);
    }

    @Override
    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }

    @Override
    public RoleDto findRole(Long id) {
        Role role = roleRepository.findById(id).orElse(null);
        
        RoleDto roleDto = new RoleDto();
        
        //Mapeo
        roleDto.setType(role.getType());
        roleDto.setDescription(role.getDescription());
        
        return roleDto;
    } 
}
