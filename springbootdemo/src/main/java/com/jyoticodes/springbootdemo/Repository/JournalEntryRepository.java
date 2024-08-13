package com.jyoticodes.springbootdemo.Repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;

import com.jyoticodes.springbootdemo.Entity.JournalEntry;

@Component
public interface JournalEntryRepository extends MongoRepository<JournalEntry, ObjectId>{

}
