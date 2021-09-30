package com.cjour.mediscreennote.service;

import com.cjour.mediscreennote.model.Note;
import com.cjour.mediscreennote.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class NoteService implements INoteService {

    @Autowired
    NoteRepository noteRepository;

    @Override
    public List<Note> findAll() {
        return noteRepository.findAll();
    }

    public List<Note> findNotesById(UUID patientId) {
        List<Note> listOfNote = this.findAll();
        List<Note> listOfNoteForThisUUID = new ArrayList<>();
        for (Note note : listOfNote) {
            if (note.getPatId().equals(patientId)){
                listOfNoteForThisUUID.add(note);
            }
        }
        return listOfNoteForThisUUID;
    }

    @Override
    public Note create(Note note) {
        //note.setCreationDate(new Date());
        return noteRepository.insert(note);
    }
}
