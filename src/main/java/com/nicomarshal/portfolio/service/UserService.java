package com.nicomarshal.portfolio.service;

import com.nicomarshal.portfolio.model.User;
import com.nicomarshal.portfolio.repository.IUserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public List<User> getUsers() {
        List<User> listUsers = userRepository.findAll();
        return listUsers;
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User findUser(Long id) {
        User user = userRepository.findById(id).orElse(null);
        return user;
    }
    
    
}
