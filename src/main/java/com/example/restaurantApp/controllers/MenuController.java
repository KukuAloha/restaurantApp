package com.example.restaurantApp.controllers;


import com.example.restaurantApp.domain.Menu;
import com.example.restaurantApp.services.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping
    public List<Menu> getMenuByRestaurantId(@Param("id") int id){
        return menuService.getMenuByRestaurantId(id);
    }
    @PostMapping
    public void addMenu(@RequestBody Menu menu,
                        @Param("id") int id){
        menuService.addMenu(menu, id);
    }
    @PostMapping(
            path = "{menuId}/image/upload",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public void uploadRestaurantImage(@PathVariable("menuId") int menuId,
                                      @RequestParam("file") MultipartFile file) {
        menuService.uploadMenuImage(menuId, file);

    }

    @DeleteMapping
    public int deleteMenu(@RequestParam int id){ return menuService.deleteMenu(id); }

}
