package com.example.restaurantApp.services.impl;

import com.example.restaurantApp.domain.User;
import com.example.restaurantApp.repository.UserRepository;
import com.example.restaurantApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers(){
        return (List<User>) userRepository.findAll();
    }

    @Override
    public int addUser(User user) {
        return userRepository.save(user).getId();
    }

    @Override
    public int deleteUser(int id) {
        userRepository.deleteById(id);
        return id;
    }
}
