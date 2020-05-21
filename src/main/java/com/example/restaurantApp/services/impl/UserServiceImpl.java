package com.example.restaurantApp.services.impl;

import com.example.restaurantApp.domain.Role;
import com.example.restaurantApp.domain.User;
import com.example.restaurantApp.repository.RoleRepository;
import com.example.restaurantApp.repository.UserRepository;
import com.example.restaurantApp.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

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

    @Override
    public User register(User user) {
        Role roleUser = roleRepository.findByName("USER");
        List<Role> userRoles = new ArrayList<>();
        userRoles.add(roleUser);

        user.setFirstName(user.getFirstName());
        user.setLastName(user.getLastName());

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(userRoles);

        User registeredUser = userRepository.save(user);


        return registeredUser;
    }

    @Override
    public User findByUserName(String username) {

        User user =  userRepository.findUserByLogin(username);


        return user;
    }

    @Override
    public User findById(int id) {

        User user = userRepository.findById(id).orElse(null);

        if(user == null) {
            return null;
        }


        return user;
    }
}
