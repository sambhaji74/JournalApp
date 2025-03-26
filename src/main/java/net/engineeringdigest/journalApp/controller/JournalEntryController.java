package net.engineeringdigest.journalApp.controller;

import net.engineeringdigest.journalApp.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    //we dont have database connection so we use map for  entries , later we will  connect to the database
    private Map<Long, JournalEntry> journalEntries = new HashMap();


   @GetMapping
   public List<JournalEntry> getAll() {
       return new ArrayList<>(journalEntries.values());
   }

   @PostMapping
   public  String  createEntry(@RequestBody JournalEntry journalEntry){

       journalEntries.put(journalEntry.getId(), journalEntry);

       return "data added successfully";


       }

    @GetMapping("/path/{myId}")
    public JournalEntry getJournalEntryById(@PathVariable Long myId){
       return journalEntries.get(myId);
    }

    @DeleteMapping("/path/{myId}")
    public JournalEntry deleteEntryById(@PathVariable Long myId){
        return journalEntries.remove(myId);


    }

    @PutMapping("/path/{myId}")
    public JournalEntry updateJournalById(@PathVariable Long myId , @RequestBody JournalEntry journalEntry){

       return journalEntries.put(myId , journalEntry);

    }

    //inn above put method , we will send id  to update the specific record ,
    // along with that we need to pass the updated data  also . means id will remain same but other data wil change



    }
