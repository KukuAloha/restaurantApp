package com.example.restaurantApp.controllers;


import com.example.restaurantApp.domain.Menu;
import com.example.restaurantApp.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping
    public List<Menu> getAllMenu(){
        return menuService.getAllMenu();
    }

    @PutMapping
    public int addMenu(@RequestBody Menu menu){
        return menuService.addMenu(menu);
    }

    @DeleteMapping
    public int deleteMenu(@RequestParam int id){ return menuService.deleteMenu(id); }
}
