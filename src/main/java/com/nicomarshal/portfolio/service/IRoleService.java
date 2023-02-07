package com.nicomarshal.portfolio.service;

import com.nicomarshal.portfolio.dto.RoleDto;
import java.util.List;

public interface IRoleService {
    
    public List<RoleDto> getRoles();
    
    public void createRole(RoleDto roleDto);
    
    public void editRole(Long id, RoleDto roleDto);
    
    public void deleteRole(Long id);
    
    public RoleDto findRole(Long id);
}