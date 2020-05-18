package com.example.restaurantApp.services;

import com.example.restaurantApp.domain.Menu;
import com.example.restaurantApp.dto.MenuDto;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface MenuService {

    void addMenu(MenuDto menuDto, int id);

    int deleteMenu(int id);

    List<Menu> getMenuByRestaurantId(int id);

    void uploadMenuImage(int menuId, MultipartFile file);
}
