package com.example.restaurantApp.services;

import com.example.restaurantApp.domain.Cuisine;
import com.example.restaurantApp.domain.Menu;

import java.util.List;

public interface CuisineService {
    List<Cuisine> getAllCuisines();
    int addCuisine(Cuisine cuisine);
}
