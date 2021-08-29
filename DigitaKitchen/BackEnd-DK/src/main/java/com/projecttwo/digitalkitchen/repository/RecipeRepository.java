package com.projecttwo.digitalkitchen.repository;

import com.projecttwo.digitalkitchen.model.Recipe;
import com.projecttwo.digitalkitchen.model.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Repository
public interface RecipeRepository extends MongoRepository<Recipe, ObjectId> {

    Page<Recipe> findAll(Pageable pageable);

    Page<Recipe> findByNameIgnoreCase(String name,Pageable pageable);

    Page<Recipe> findByCategoryInIgnoreCase(List<String> category,Pageable pageable);

    public List<Recipe> findByNameIgnoreCase(final String name);

    List<Recipe> findByCategoryInIgnoreCase(List<String> category);

    Page<Recipe> findByUserIgnoreCase(User user,Pageable pageable);
}
