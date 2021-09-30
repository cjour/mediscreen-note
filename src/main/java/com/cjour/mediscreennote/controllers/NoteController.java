package com.cjour.mediscreennote.controllers;

import com.cjour.mediscreennote.model.Note;
import com.cjour.mediscreennote.service.INoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/notes/patient/{id}")
    public ResponseEntity<List<Note>> getNotes(@PathVariable UUID id){
        List<Note> listOfNotes = noteService.findNotesById(id);
        return new ResponseEntity<>(listOfNotes, HttpStatus.OK);
    }

    @PostMapping("/patHistory/add")
    public ResponseEntity<Note> addANote(@RequestBody Note note){
        noteService.create(note);
        return new ResponseEntity<>(note, HttpStatus.CREATED);
    }
}
