package com.example.restaurantApp.services;

import com.example.restaurantApp.domain.Dish;

import java.util.List;

public interface DishService {
    List<Dish> getAllDishes();
    int addDish(Dish dish);
}
