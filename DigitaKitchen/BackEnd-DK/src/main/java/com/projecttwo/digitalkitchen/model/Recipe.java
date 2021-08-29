package com.projecttwo.digitalkitchen.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.List;

@Document
public class Recipe {

    @Id
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JsonSerialize(using= ToStringSerializer.class)
    private ObjectId id;
    private String name;
    @Field("Prep_Time")
    private String preparation_time;
    @Field("Total_Time")
    private String total_time;
    @Field("image_path")
    private String image_url;
    @Field("Ingredients")
    private ArrayList<Ingredient> ingredients;
    @Field("Steps")
    private  List<String> steps;
    private List<String>  category;
    private int rating;
    @DBRef
    @Field(value = "user_id")
    private User user;
    @Field("Nutrition_Value")
    private ArrayList<Nutrient> nutrients;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPreparation_time() {
        return preparation_time;
    }

    public void setPreparation_time(String preparation_time) {
        this.preparation_time = preparation_time;
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

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

        public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    @Override
    public String toString() {
        return "Recipe{" +
                "_id=" + id +
                ", name='" + name + '\'' +
                ", prepration_time='" + preparation_time + '\'' +
                ", total_time='" + total_time + '\'' +
                ", image_path='" + image_url + '\'' +
                ", ingredients=" + ingredients +
                ", steps=" + steps +
                ", category=" + category +
                ", rating=" + rating +
                ", nutrients=" + nutrients +
                '}';
    }
}
