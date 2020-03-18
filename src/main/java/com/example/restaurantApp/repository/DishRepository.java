package com.example.restaurantApp.repository;

import com.example.restaurantApp.domain.Dish;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DishRepository extends CrudRepository<Dish, Integer> {
}
