package com.example.restaurantApp.services;

import com.example.restaurantApp.domain.Menu;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface MenuService {

    void addMenu(Menu menu, int id);
    int deleteMenu(int id);

    List<Menu> getMenuByRestaurantId(int id);

    void uploadMenuImage(int menuId, MultipartFile file);
}
