package com.jyoticodes.springbootdemo.Entity;

import java.time.LocalDateTime;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/*
 * @Data annotation = @Getter + @Setter + @NoArgsConstructor + A@rgsConstructor + @toString
 */
@Getter
@Setter
@NoArgsConstructor
@Data
@Document(collection = "journal_entries")
public class JournalEntry {
    @Id
    private ObjectId id;
    private String name;
    private String content;
    private LocalDateTime date;
    // public LocalDateTime getDate() {
    //     return date;
    // }
    // public void setDate(LocalDateTime date) {
    //     this.date = date;
    // }
    // public ObjectId getId() {
    //     return id;
    // }
    // public String getName() {
    //     return name;
    // }
    // public String getContent() {
    //     return content;
    // }
    // public void setId(ObjectId id) {
    //     this.id = id;
    // }
    // public void setName(String name) {
    //     this.name = name;
    // }
    // public void setContent(String content) {
    //     this.content = content;
    // }
    
}
