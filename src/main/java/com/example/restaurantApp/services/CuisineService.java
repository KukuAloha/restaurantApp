package com.example.restaurantApp.services;

import com.example.restaurantApp.domain.Cuisine;
import com.example.restaurantApp.domain.Menu;
import com.example.restaurantApp.dto.CuisineDto;

import java.util.List;

public interface CuisineService {

    List<Cuisine> getAllCuisines();

    int addCuisine(CuisineDto cuisineDto);

    int deleteCuisine(int id);
}
