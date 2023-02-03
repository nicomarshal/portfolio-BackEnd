package com.nicomarshal.portfolio.service;

import java.util.List;
import com.nicomarshal.portfolio.model.Role;

public interface IRoleService {
    
    public List<Role> getRoles();
    
    public void saveRole(Role role);
    
    public void deleteRole(Long id);
    
    public Role findRole(Long id);
}