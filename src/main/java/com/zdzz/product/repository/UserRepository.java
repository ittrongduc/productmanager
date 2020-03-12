package com.zdzz.product.repository;

import com.zdzz.product.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

}
