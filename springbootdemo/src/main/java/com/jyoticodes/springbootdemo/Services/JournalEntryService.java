package com.jyoticodes.springbootdemo.Services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jyoticodes.springbootdemo.Entity.JournalEntry;
import com.jyoticodes.springbootdemo.Entity.User;
import com.jyoticodes.springbootdemo.Repository.JournalEntryRepository;
import com.jyoticodes.springbootdemo.Repository.UserRepository;

import jakarta.transaction.Transactional;

@Component
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository;
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void savejournal(JournalEntry entry, String userName)
    {
        try{
            User user = userRepository.findByUserName(userName);
            entry.setDate(LocalDateTime.now());
            JournalEntry saved = journalEntryRepository.save(entry); // saving journal entry
            user.getJournalentries().add(saved); //save journal entries of the corresponding user
            userRepository.save(user); // Saving user after adding journalentries to the arraylist
        }
        catch(Exception e){
            System.out.println("Exception occurred while saving entries. "+e);
        }
        
    }

    @Transactional
    public void deleteEntryById(ObjectId id , String userName)
    {
        User user = userRepository.findByUserName(userName);
        user.getJournalentries().removeIf(x-> x.getId().equals(id));
        userRepository.save(user);
        journalEntryRepository.deleteById(id);
    }

    public void savejournal(JournalEntry entry)
    {
        journalEntryRepository.save(entry);
    }

    public ArrayList<JournalEntry> getAllJournalEntries()
    {
        return (ArrayList<JournalEntry>) journalEntryRepository.findAll();
    }

    public Optional<JournalEntry> findJournalEntryById(ObjectId id)
    {
        return journalEntryRepository.findById(id);
    }

    public void deleteAllEntries()
    {
        journalEntryRepository.deleteAll();
    }
}
