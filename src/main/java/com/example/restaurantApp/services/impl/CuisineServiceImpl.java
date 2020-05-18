package com.example.restaurantApp.services.impl;

import com.example.restaurantApp.domain.Cuisine;
import com.example.restaurantApp.dto.CuisineDto;
import com.example.restaurantApp.repository.CuisineRepository;
import com.example.restaurantApp.services.CuisineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CuisineServiceImpl implements CuisineService {
    @Autowired
    private CuisineRepository cuisineRepository;

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

}
