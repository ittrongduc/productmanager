package com.zdzz.product.repository;

import com.zdzz.product.model.OrderDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderDetailsRepository extends MongoRepository<OrderDetails, String> {

}
