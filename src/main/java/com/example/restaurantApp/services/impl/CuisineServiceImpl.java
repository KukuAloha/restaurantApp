package com.example.restaurantApp.services.impl;

import com.example.restaurantApp.domain.Cuisine;
import com.example.restaurantApp.domain.Restaurant;
import com.example.restaurantApp.dto.CuisineDto;
import com.example.restaurantApp.repository.CuisineRepository;
import com.example.restaurantApp.repository.RestaurantRepository;
import com.example.restaurantApp.services.CuisineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class CuisineServiceImpl implements CuisineService {
    @Autowired
    private CuisineRepository cuisineRepository;
    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public List<Cuisine> getAllCuisines() {
        return (List<Cuisine>) cuisineRepository.findAll();
    }

    @Override
    public int addCuisine(CuisineDto cuisineDto) {
        Cuisine cuisine = new Cuisine();

        cuisine.setName(cuisineDto.getName());

        return cuisineRepository.save(cuisine).getId();
    }

    @Override
    public int deleteCuisine(int id) {
        cuisineRepository.deleteById(id);
        return id;
    }

    @Override
    public List<Cuisine> getCuisinesForRestaurant(int id) {
        Restaurant restaurant = restaurantRepository.findById(id).get();

        return cuisineRepository.findCuisinesByRestaurants(restaurant);
    }

    @Override
    public List<Restaurant> getRestaurantsByCuisine(int id) {
        Cuisine cuisine = cuisineRepository.findById(id).get();

        return restaurantRepository.findRestaurantsByCuisines(cuisine);
    }

    @Override
    public void addCuisineToRestaurant(int idOfRestaurant, int idCuisine) {
        Cuisine cuisine = cuisineRepository.findById(idCuisine).get();

        Restaurant restaurant = restaurantRepository.findById(idOfRestaurant).get();

        restaurant.getCuisines().add(cuisine);
        cuisine.getRestaurants().add(restaurant);

        cuisineRepository.save(cuisine);
        restaurantRepository.save(restaurant);
    }
}
