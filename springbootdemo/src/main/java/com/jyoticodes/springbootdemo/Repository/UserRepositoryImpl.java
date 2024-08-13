package com.jyoticodes.springbootdemo.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

public class UserRepositoryImpl {

    @Autowired
    private MongoTemplate mongoTemplate;

}
