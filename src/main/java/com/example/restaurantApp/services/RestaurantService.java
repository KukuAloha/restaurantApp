package com.example.restaurantApp.services;

import com.example.restaurantApp.domain.Restaurant;
import com.example.restaurantApp.dto.RestaurantDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface RestaurantService {
    List<Restaurant> getAllRestaurants();
    int addRestaurant(RestaurantDto restaurant);
    int deleteRestaurant(int id);

    void uploadRestaurantImage(int restaurantId, MultipartFile file);

    Restaurant getRestaurantByName(String name);
}
