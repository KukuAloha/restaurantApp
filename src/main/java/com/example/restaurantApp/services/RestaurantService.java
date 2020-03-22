package com.example.restaurantApp.services;

import com.example.restaurantApp.domain.Restaurant;

import java.util.List;

public interface RestaurantService {
    List<Restaurant> getAllRestaurants();
    int addRestaurant(Restaurant restaurant);
    int deleteRestaurant(int id);
}
