package com.example.restaurantApp.services;

import com.example.restaurantApp.domain.Menu;

import java.util.List;

public interface MenuService {
    List<Menu> getAllMenu();
    int addMenu(Menu menu);
    int deleteMenu(int id);
}
