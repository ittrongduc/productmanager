package com.zdzz.product.service;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.zdzz.product.constant.EnvironmentVariable;
import com.zdzz.product.driver.MongoDBDriver;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ProductDAO {

    @Autowired
    private MongoDBDriver mongoDBDriver;

    public Set<Document> getAllProducts(){
        Set<Document> allProds = new HashSet<>();
        try {
            MongoCollection<Document> tproductCol = mongoDBDriver.getMongoClient()
                    .getDatabase(EnvironmentVariable.MONGODB_DATABASE_NAME)
                    .getCollection(EnvironmentVariable.MONGODB_COLLECTION_PRODUCT);

            MongoCursor<Document> cursor = tproductCol.find().iterator();
            while (cursor.hasNext()){
                allProds.add(cursor.next());
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            mongoDBDriver.getMongoClient().close();
        }
        return allProds;
    }
}
