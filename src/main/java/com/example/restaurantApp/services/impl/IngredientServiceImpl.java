package com.example.restaurantApp.services.impl;

import com.example.restaurantApp.bucket.BucketName;
import com.example.restaurantApp.domain.Dish;
import com.example.restaurantApp.domain.Ingredient;
import com.example.restaurantApp.domain.Restaurant;
import com.example.restaurantApp.dto.IngredientDto;
import com.example.restaurantApp.filestore.FileStore;
import com.example.restaurantApp.repository.DishRepository;
import com.example.restaurantApp.repository.IngredientRepository;
import com.example.restaurantApp.services.IngredientService;
import org.apache.http.entity.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.IOException;
import java.util.*;

@Service
public class IngredientServiceImpl implements IngredientService {
    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private DishRepository dishRepository;

    @Autowired
    private FileStore fileStore;

    @Override
    public List<Ingredient> getAllIngredient() {
        return (List<Ingredient>) ingredientRepository.findAll();
    }

    @Override
    public List<Ingredient> getIngredientsByDishId(int id) {
        Dish dish = dishRepository.findDishById(id);
        return ingredientRepository.findIngredientsByDishes(dish);
    }

    @Override
    public void addIngredient(IngredientDto ingredientDto) {
        Ingredient ingredient = new Ingredient();

        ingredient.setName(ingredientDto.getName());
        ingredient.setWeight(ingredientDto.getWeight());
        ingredientRepository.save(ingredient);
    }

    @Override
    public void addIngredientToDish(int idOfIngredient, int idOfDish) {
        Ingredient ingredient = ingredientRepository.findById(idOfIngredient).get();
        Dish dish = dishRepository.findById(idOfDish).get();
        ingredient.getDishes().add(dish);
        dish.getIngredients().add(ingredient);
        ingredientRepository.save(ingredient);
        dishRepository.save(dish);
    }


    @Override
    public void uploadIngredientImage(int ingredientId, MultipartFile file) {
        isFileEmpty(file);

        isImage(file);

        Ingredient ingredient = getIngredientsOrThrow(ingredientId);

        Map<String, String> metadata = extractMetadata(file);

        String path = String.format("%s/%s/%s", BucketName.PROFILE_IMAGE.getBucketName(), "Ingredients", ingredient.getId());
        String filename = String.format("%s", file.getOriginalFilename());

        try {
            fileStore.save(path, filename, Optional.of(metadata), file.getInputStream());
            String link = "https://kray-bucket.s3.us-east-2.amazonaws.com/Ingredients/" + ingredientId + "/" + filename;
            ingredientRepository.updateIngredientLinkById(ingredientId, link);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public int deleteIngredient(int id) {
        ingredientRepository.deleteById(id);
        return id;
    }

    private Map<String, String> extractMetadata(MultipartFile file) {
        Map<String, String> metadata = new HashMap<>();
        metadata.put("Content-Type", file.getContentType());
        metadata.put("Content-Length", String.valueOf(file.getSize()));
        return metadata;
    }

    private Ingredient getIngredientsOrThrow(int ingredientId) {
        return getAllIngredient()
                .stream()
                .filter(ingredient -> ingredient.getId() == ingredientId )
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(String.format("Ingredient %s not found", ingredientId)));
    }

    private void isImage(MultipartFile file) {
        if (!Arrays.asList(ContentType.IMAGE_JPEG.getMimeType(),
                ContentType.IMAGE_PNG.getMimeType(),
                ContentType.IMAGE_GIF.getMimeType()).contains(file.getContentType())) {
            throw new IllegalStateException("File must be an image [" + file.getContentType() + "]");
        }
    }

    private void isFileEmpty(MultipartFile file) {
        if (file.isEmpty()) {
            throw new IllegalStateException("Cannot upload empty file [ " + file.getSize() + "]");
        }
    }
}
