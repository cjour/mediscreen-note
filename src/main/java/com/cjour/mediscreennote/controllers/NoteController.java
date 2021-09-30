package com.cjour.mediscreennote.controllers;

import com.cjour.mediscreennote.model.Note;
import com.cjour.mediscreennote.service.INoteService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class NoteController {

    @Autowired
    INoteService noteService;

    @GetMapping("/")
    public String home(){
        return "welcome to mediscreen note";
    }

    @GetMapping("/notes")
    public List<Note> getAllNotes() {
        return noteService.findAll();
    }

    @GetMapping("/patientNote/{id}")
    public ResponseEntity<List<Note>> getNotes(@PathVariable Integer id){
        List<Note> listOfNotes = noteService.findNotesById(id);
        return new ResponseEntity<>(listOfNotes, HttpStatus.OK);
    }

    @PostMapping("/patientNote/add")
    public ResponseEntity<Note> addANote(@RequestBody Note note){
        Note noteCreated = noteService.create(note);
        return new ResponseEntity<>(noteCreated, HttpStatus.CREATED);
    }

    @PutMapping("/patientNote/update/{id}")
    public ResponseEntity<Note> updateANote(@PathVariable ObjectId id, @RequestBody Note note){
       Note noteUpdated = noteService.update(id, note);
        return new ResponseEntity<>(noteUpdated, HttpStatus.CREATED);
    }

    @DeleteMapping("/patientNote/delete/{id}")
    public ResponseEntity<Note> deleteANote(@PathVariable ObjectId id){
        noteService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
