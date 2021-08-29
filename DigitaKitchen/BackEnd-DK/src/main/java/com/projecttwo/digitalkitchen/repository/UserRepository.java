package com.projecttwo.digitalkitchen.repository;

import com.projecttwo.digitalkitchen.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User,String> {

    User findByNameIgnoreCase(String name);
}
