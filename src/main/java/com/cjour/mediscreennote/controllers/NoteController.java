package com.cjour.mediscreennote.controllers;

import com.cjour.mediscreennote.model.Note;
import com.cjour.mediscreennote.service.INoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/patientNote/note/{id}")
    public ResponseEntity<Note> getNotes(@PathVariable String id){
        Note note = noteService.findNoteById(id);
        return new ResponseEntity<>(note, HttpStatus.OK);
    }

//    @GetMapping("/patientNote/{id}")
//    public ResponseEntity<List<Note>> getNotesByFamilyName(@PathVariable String familyName){
//        List<Note> listOfNotes = noteService.findNotesByFamilyName(familyName);
//        return new ResponseEntity<>(listOfNotes, HttpStatus.OK);
//    }

    @PostMapping("/patientNote/add")
    public ResponseEntity<Note> addANote(@RequestBody Note note){
        Note noteCreated = noteService.create(note);
        return new ResponseEntity<>(noteCreated, HttpStatus.CREATED);
    }

    @PutMapping("/patientNote/update/{id}")
    public ResponseEntity<Note> updateANote(@PathVariable String id, @RequestBody Note note){
        Note noteUpdated = noteService.update(id, note);
        return new ResponseEntity<>(noteUpdated, HttpStatus.CREATED);
    }

    @DeleteMapping("/patientNote/delete/{id}")
    public ResponseEntity<Note> deleteANote(@PathVariable String id){
        noteService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
