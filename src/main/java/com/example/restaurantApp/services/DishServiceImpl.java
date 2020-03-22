package com.example.restaurantApp.services;

import com.example.restaurantApp.domain.Dish;
import com.example.restaurantApp.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishServiceImpl implements DishService{
    @Autowired
    private DishRepository dishRepository;

    @Override
    public List<Dish> getAllDishes() {
        return (List<Dish>) dishRepository.findAll();
    }

    @Override
    public int addDish(Dish dish) {
        return dishRepository.save(dish).getId();
    }

    @Override
    public int deleteDish(int id) {
        dishRepository.deleteById(id);
        return id;
    }
}
