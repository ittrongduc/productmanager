//package com.zdzz.product.driver;
//
//import com.mongodb.MongoClient;
//import com.mongodb.MongoClientURI;
//import com.mongodb.client.MongoDatabase;
//import com.zdzz.product.constant.EnvironmentVariable;
//import org.springframework.stereotype.Repository;
//import org.springframework.stereotype.Service;
//
//import java.util.Objects;
//
//@Repository
//public class MongoDBDriver {
//
//    private static MongoDBDriver mongoDBDriver;
//
//    private MongoClientURI uri;
//    private MongoClient mongoClient;
//    private MongoDatabase database;
//
//    private MongoClientURI getUri(){
//        if (Objects.nonNull(uri)){
//            return uri;
//        }else {
//            this.uri = new MongoClientURI(
//                    "mongodb+srv://"+ EnvironmentVariable.MONGODB_USERNAME +":"+ EnvironmentVariable.MONGODB_PASSWORD +"@dev-cluster-ro7fk.gcp.mongodb.net/test?retryWrites=true&w=majority");
//            return uri;
//        }
//    }
//
//    public MongoClient getMongoClient(){
//        if (Objects.nonNull(mongoClient)){
//            return mongoClient;
//        }else {
//            this.mongoClient = new MongoClient(getUri());
//            return mongoClient;
//        }
//    }
//
//    private MongoDBDriver(){}
//
//    public static MongoDBDriver getInstance(){
//        if (null == mongoDBDriver){
//            return new MongoDBDriver();
//        }
//        return mongoDBDriver;
//    }
//
//
//}
