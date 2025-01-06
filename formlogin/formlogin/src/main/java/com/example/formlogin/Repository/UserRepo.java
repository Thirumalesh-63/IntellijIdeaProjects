package com.example.formlogin.Repository;

import com.zapcom.common.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends MongoRepository<User, Integer> {

    User findByName(String name);
}
