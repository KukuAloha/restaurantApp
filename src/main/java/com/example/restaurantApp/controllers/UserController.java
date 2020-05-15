package com.example.restaurantApp.controllers;

import com.example.restaurantApp.domain.User;
import com.example.restaurantApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController{

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping
    public int addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @DeleteMapping
    public int deleteUser(@RequestParam int id){ return userService.deleteUser(id); }

}
