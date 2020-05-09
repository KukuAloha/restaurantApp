package com.example.restaurantApp.controllers;

import com.example.restaurantApp.domain.Ingredient;
import com.example.restaurantApp.services.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/ingredient")
public class IngredientController {

    @Autowired
    private IngredientService ingredientService;

    @GetMapping
    public List<Ingredient> getAllIngredients(){
        return ingredientService.getAllIngredient();
    }

    @PostMapping
    public void addNewIngredient(@RequestBody Ingredient ingredient){
        ingredientService.addIngredient(ingredient);
    }

    @PostMapping("bindIngredient")
    public void addIngredientToDish(@Param("idOfIngredient") int idOfIngredient,
                                    @Param("idOfDish") int idOfDish) {
        ingredientService.addIngredientToDish(idOfIngredient, idOfDish);
    }

    @PostMapping(
            path = "{ingredientId}/image/upload",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public void uploadRestaurantImage(@PathVariable("ingredientId") int ingredientId,
                                      @RequestParam("file") MultipartFile file) {
        ingredientService.uploadIngredientImage(ingredientId, file);

    }

    @DeleteMapping
    public int deleteIngredient(@RequestParam int id){ return ingredientService.deleteIngredient(id);}
}
