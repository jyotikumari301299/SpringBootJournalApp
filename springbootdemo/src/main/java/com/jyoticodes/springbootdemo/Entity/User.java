package com.jyoticodes.springbootdemo.Entity;

import java.util.ArrayList;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
import lombok.Data;
import lombok.NonNull;


@Document(collection="Users")
@Data
public class User {
    @Id
    private ObjectId id;
    @Indexed(unique = true)
    @NonNull
    private String userName;
    @NonNull
    private String password;
    @DBRef
    private ArrayList<JournalEntry> journalentries = new ArrayList<JournalEntry>();
    
}
