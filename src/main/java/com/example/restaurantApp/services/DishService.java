package com.example.restaurantApp.services;

import com.example.restaurantApp.domain.Dish;
import com.example.restaurantApp.dto.DishDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface DishService {
    List<Dish> getAllDishesByMenuId(int id);

    void addDish(DishDto dishDto, int id);

    int deleteDish(int id);

    void uploadDishImage(int dishId, MultipartFile file);
}
