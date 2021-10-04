package com.cjour.mediscreennote.service;

import com.cjour.mediscreennote.model.Note;
import com.cjour.mediscreennote.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NoteService implements INoteService {

    @Autowired
    NoteRepository noteRepository;

    @Override
    public List<Note> findAll() {
        return noteRepository.findAll();
    }

    public List<Note> findNotesById(Integer patientId) {
        List<Note> listOfNote = this.findAll();
        List<Note> listOfNoteForThisId = new ArrayList<>();
        for (Note note : listOfNote) {
            if (note.getPatId().equals(patientId)){
                listOfNoteForThisId.add(note);
            }
        }
        return listOfNoteForThisId;
    }

    @Override
    public Note create(Note note) {
        return noteRepository.insert(note);
    }

    @Override
    public Note update(String id, Note note) {
        Optional<Note> noteToUpdate;
        if (note != null) {
            noteToUpdate = noteRepository.findById(id);
            if (noteToUpdate.isPresent()) {
                noteToUpdate.get().setDescription(note.getDescription());
                return noteRepository.save(noteToUpdate.get());
            }
        }
        return null;
    }


    @Override
    public void delete(String id) {
        noteRepository.deleteById(id);
    }
}
