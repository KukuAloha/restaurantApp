package com.example.restaurantApp.services;


import com.example.restaurantApp.domain.Restaurant;
import com.example.restaurantApp.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;


    @Override
    public List<Restaurant> getAllRestaurants() {
        return (List<Restaurant>) restaurantRepository.findAll();
    }

    @Override
    public int addRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant).getId();
    }
}
