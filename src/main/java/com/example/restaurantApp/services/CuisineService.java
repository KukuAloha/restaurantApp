package com.example.restaurantApp.services;

import com.example.restaurantApp.domain.Cuisine;
import com.example.restaurantApp.domain.Menu;
import com.example.restaurantApp.domain.Restaurant;
import com.example.restaurantApp.dto.CuisineDto;

import java.util.List;

public interface CuisineService {

    List<Cuisine> getAllCuisines();

    int addCuisine(CuisineDto cuisineDto);

    int deleteCuisine(int id);

    List<Cuisine> getCuisinesForRestaurant(int id);

    List<Restaurant> getRestaurantsByCuisine(int id);

    void addCuisineToRestaurant(int idOfRestaurant, int idCuisine);
}
