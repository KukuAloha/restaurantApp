package com.example.restaurantApp.services;

import com.example.restaurantApp.domain.User;

import java.util.List;


public interface UserService {
    List<User> getAllUsers();
    int addUser(User user);
    int deleteUser(int id);
}
