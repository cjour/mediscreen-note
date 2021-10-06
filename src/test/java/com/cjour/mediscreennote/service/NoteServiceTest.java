package com.cjour.mediscreennote.service;

import com.cjour.mediscreennote.model.Note;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class NoteServiceTest {

    @Autowired
    INoteService noteService;

    private String noteId;


    @BeforeEach
    public void setUp() {
        noteService.create(new Note());
        for (Note note : noteService.findAll()) {
            this.noteId = note.getId();
        }
    }

    @AfterEach
    public void tearDown() {
        List<Note> listOfNotes = noteService.findAll();
        for (Note note: listOfNotes) {
            noteService.delete(note.getId());
        }
    }

    @Test
    public void should_find_all_notes(){
        List<Note> listOfNotes = noteService.findAll();
        Assertions.assertEquals(listOfNotes.size(), 1);
    }


    @Test
    public void should_update_note() {
        noteService.update(noteId, new Note());

    }
}
