package com.example.restaurantApp.controllers;

import com.example.restaurantApp.domain.Restaurant;
import com.example.restaurantApp.dto.RestaurantDto;
import com.example.restaurantApp.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping
    public List<Restaurant> getAllRestaurants(){
        return restaurantService.getAllRestaurants();
    }

    @PostMapping
    public int addRestaurant(@RequestBody RestaurantDto restaurant){
        return  restaurantService.addRestaurant(restaurant);
    }

    @PostMapping(
            path = "{restaurantId}/image/upload",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public void uploadRestaurantImage(@PathVariable("restaurantId") int restaurantId,
                                       @RequestParam("file") MultipartFile file) {
        restaurantService.uploadRestaurantImage(restaurantId, file);

    }

    @GetMapping("/getByName")
    public Restaurant getRestaurantByName(@RequestParam("name") String name) {
        return restaurantService.getRestaurantByName(name);
    }

    @DeleteMapping
    public int deleteRestaurant(@RequestParam int id){
        return restaurantService.deleteRestaurant(id);
    }
}
