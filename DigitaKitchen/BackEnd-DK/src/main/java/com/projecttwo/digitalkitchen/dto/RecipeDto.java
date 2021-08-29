package com.projecttwo.digitalkitchen.dto;

import com.projecttwo.digitalkitchen.model.Ingredient;
import com.projecttwo.digitalkitchen.model.Nutrient;

import java.util.ArrayList;
import java.util.List;

public class RecipeDto {

    private String name;

    private String prepration_time;

    private String total_time;

    private ArrayList<Ingredient> ingredients;

    private  List<String> steps;
    private List<String> category;
    private int rating;

    //    @Field(value = "user_id")
    //   private User user_id;

    private ArrayList<Nutrient> nutrients;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrepration_time() {
        return prepration_time;
    }

    public void setPrepration_time(String prepration_time) {
        this.prepration_time = prepration_time;
    }

    public String getTotal_time() {
        return total_time;
    }

    public void setTotal_time(String total_time) {
        this.total_time = total_time;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getSteps() {
        return steps;
    }

    public void setSteps(List<String> steps) {
        this.steps = steps;
    }

    public List<String> getCategory() {
        return category;
    }

    public void setCategory(List<String> category) {
        this.category = category;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public ArrayList<Nutrient> getNutrients() {
        return nutrients;
    }

    public void setNutrients(ArrayList<Nutrient> nutrients) {
        this.nutrients = nutrients;
    }
}
