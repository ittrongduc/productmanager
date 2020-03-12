package com.zdzz.product.repository;

import com.zdzz.product.model.Attributes;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AttributesRepository extends MongoRepository<Attributes, String> {

}
