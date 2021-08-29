package com.projecttwo.digitalkitchen.service;

import com.projecttwo.digitalkitchen.model.Recipe;
import com.projecttwo.digitalkitchen.model.User;
import com.projecttwo.digitalkitchen.repository.RecipeRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class RecipeService {

    @Autowired
    RecipeRepository recipeRepository;

    public List<Recipe> getRecipeByName(String recipeName){
      return recipeRepository.findByNameIgnoreCase(recipeName);
    }

    public Page<Recipe> getRecipeByName(int page, int size,String recipeName){
        Pageable pageable = PageRequest.of(page,size);
        return recipeRepository.findByNameIgnoreCase(recipeName,pageable);
    }

    public Page<Recipe> getRecipeByCategory(int page, int size,String category){
        Pageable pageable = PageRequest.of(page,size);
        return recipeRepository.findByCategoryInIgnoreCase(Arrays.asList(category),pageable);
    }

    public Page<Recipe> getRecipeByUser(int page, int size, User user){
        Pageable pageable = PageRequest.of(page,size);
        return recipeRepository.findByUserIgnoreCase(user,pageable);
    }


    public Page<Recipe> findnRecipe(int page, int size){
        Pageable pageable = PageRequest.of(page,size);
        return  recipeRepository.findAll(pageable);
    }

    public List<Recipe> getRecipeByCategory(String category){
        return  recipeRepository.findByCategoryInIgnoreCase(Arrays.asList(category));
    }

    public Recipe getRecipeById(ObjectId id){

        return  recipeRepository.findById(id).get();
    }
}
