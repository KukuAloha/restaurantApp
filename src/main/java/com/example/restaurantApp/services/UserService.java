package com.example.restaurantApp.services;

import com.example.restaurantApp.domain.User;

import java.util.List;


public interface UserService {
    List<User> getAllUsers();
    int addUser(User user);
    int deleteUser(int id);

    User register(User user);

    User findByUserName(String username);

    User findById(int id);


}
