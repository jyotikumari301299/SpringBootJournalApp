package com.jyoticodes.springbootdemo.Controller;

import java.util.ArrayList;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jyoticodes.springbootdemo.Entity.JournalEntry;
import com.jyoticodes.springbootdemo.Entity.User;
import com.jyoticodes.springbootdemo.Services.JournalEntryService;
import com.jyoticodes.springbootdemo.Services.UserService;


@RestController
@RequestMapping("Journal")
public class JournalController {

    @Autowired private JournalEntryService journalEntryService;
    @Autowired private UserService userService;

    @GetMapping("/getallentries")
    public ArrayList<JournalEntry> getAllJournalEntries()
    {
        return journalEntryService.getAllJournalEntries();
    }

    @PostMapping("/createJournal/{userName}")
    public boolean createJournalEntry(@RequestBody JournalEntry myEntry, @PathVariable("userName") String userName)
    {
        journalEntryService.savejournal(myEntry, userName);
        return true;
    }

    @GetMapping("/getJournalById/{Id}")
    public ResponseEntity<JournalEntry> getJournalById(@PathVariable("Id") ObjectId id) {
        Optional<JournalEntry> entry = journalEntryService.findJournalEntryById(id);
        return entry.map(entry1-> new ResponseEntity<>(entry1,HttpStatus.OK))
                     .orElseGet(()->(new ResponseEntity(HttpStatus.NO_CONTENT)));
        // if(entry.isPresent())
        // {
        //     return new ResponseEntity<>(entry.get(),HttpStatus.OK);
        // }
        // else
        // return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        
    }

    @GetMapping("/getJournalEntriesByUser/{userName}")
    public ResponseEntity<ArrayList<JournalEntry>> getJournalEntriesByUser(@PathVariable String userName)
    {
        User user = userService.findByUserName(userName);
        return new ResponseEntity<>(user.getJournalentries(),HttpStatus.OK);
    }

    @DeleteMapping("/deleteEntryById/{userName}/{Id}")
    public void deleteEntry(@PathVariable("Id") ObjectId id, @PathVariable String userName)
    {
        journalEntryService.deleteEntryById(id,userName);
    }

    @DeleteMapping("deleteAllEntries")
    public void deleteAllEntries()
    {
        journalEntryService.deleteAllEntries();
    }

    @PutMapping("/updateEntry/{Id}")
    public ResponseEntity<JournalEntry> updateEntry(@PathVariable("Id") ObjectId id , @RequestBody JournalEntry entry)
    {
        JournalEntry journalEntry = journalEntryService.findJournalEntryById(id).orElse(null);
        if(journalEntry != null)
        {
            journalEntry.setName(entry.getName() != null ? entry.getName() : journalEntry.getName());
            journalEntry.setContent(entry.getContent() != null ? entry.getContent() : journalEntry.getContent());
        }
        journalEntryService.savejournal(journalEntry);
        return new ResponseEntity<JournalEntry>(journalEntry, HttpStatus.OK);
    }

}
