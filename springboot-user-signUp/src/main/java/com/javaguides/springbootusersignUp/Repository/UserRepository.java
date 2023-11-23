package com.javaguides.springbootusersignUp.Repository;

import com.javaguides.springbootusersignUp.Models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    User findByEmail(String email);
    // Additional custom queries or methods can be added if needed
}
