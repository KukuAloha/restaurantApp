package com.example.restaurantApp.repository;

import com.example.restaurantApp.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    User findUserByLogin(String name);
}
