package com.jyoticodes.springbootdemo.Repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.jyoticodes.springbootdemo.Entity.User;

public interface UserRepository extends MongoRepository<User ,ObjectId >{

    User findByUserName(String username);

}
