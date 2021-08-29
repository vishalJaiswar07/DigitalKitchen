package com.projecttwo.digitalkitchen.api;

import com.projecttwo.digitalkitchen.model.Recipe;
import com.projecttwo.digitalkitchen.model.User;
import com.projecttwo.digitalkitchen.repository.RecipeRepository;
import com.projecttwo.digitalkitchen.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Arrays;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class AddingCollectionController {

   @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

   @Autowired
   private RecipeRepository recipeRepository;



    @PostMapping("/private/recipes")
    public ResponseEntity<?> addNewRecipe(@RequestBody Recipe recipe,Principal principal){

        String str=principal.getName();
       User user= userRepository.findById(str).get();
        recipe.setUser(user);
        System.out.println(recipe.getUser());
        recipeRepository.save(recipe);

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();

       // return ResponseEntity.ok().body(recipe);
    }

    @PostMapping(value = "/users")
    public ResponseEntity<?> registerUser(@RequestBody User user){
        System.out.println("REGISTERING A USER............................................................");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
