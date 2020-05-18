package com.example.restaurantApp.dto;

import lombok.Data;

@Data
public class RestaurantDto {
    private String name;
    private String address;
    private String description;
    private int stars;
    private int avgCheck;
}
