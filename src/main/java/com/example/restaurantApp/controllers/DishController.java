package com.example.restaurantApp.controllers;

import com.example.restaurantApp.domain.Dish;
import com.example.restaurantApp.dto.DishDto;
import com.example.restaurantApp.services.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/dish")
public class DishController {

    @Autowired
    private DishService dishService;

    @GetMapping
    public List<Dish> getAllDishesByMenuId(@Param("id") int id){
        return dishService.getAllDishesByMenuId(id);
    }

    @PostMapping
    public void addDish(@RequestBody DishDto dish,
                       @Param("id") int id){
        dishService.addDish(dish, id);
    }

    @PostMapping(
            path = "{dishId}/image/upload",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public void uploadRestaurantImage(@PathVariable("dishId") int dishId,
                                      @RequestParam("file") MultipartFile file) {
        dishService.uploadDishImage(dishId, file);

    }

    @DeleteMapping
    public int deleteDish(@RequestParam int id){
        return dishService.deleteDish(id);
    }
}
