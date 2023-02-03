package com.nicomarshal.portfolio.service;

import com.nicomarshal.portfolio.model.User;
import java.util.List;

public interface IUserService {
    public List<User> getUsers();
    
    public void saveUser(User user);
    
    public void deleteUser(Long id);
    
    public User findUser(Long id);    
}
