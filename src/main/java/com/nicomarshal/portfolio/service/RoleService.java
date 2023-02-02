package com.nicomarshal.portfolio.service;

import com.nicomarshal.portfolio.model.Role;
import com.nicomarshal.portfolio.repository.IRoleRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

public class RoleService implements IRoleService {
    @Autowired
    private IRoleRepository roleRepository;

    @Override
    public List<Role> getRoles() {
        List<Role> listRoles = roleRepository.findAll();
        return listRoles;
    }

    @Override
    public void saveRole(Role role) {
        roleRepository.save(role);
    }

    @Override
    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }

    @Override
    public Role findRole(Long id) {
        Role role = roleRepository.findById(id).orElse(null);
        return role;
    }
}
