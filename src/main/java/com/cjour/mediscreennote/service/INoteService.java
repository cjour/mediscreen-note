package com.cjour.mediscreennote.service;

import com.cjour.mediscreennote.model.Note;

import java.math.BigInteger;
import java.util.List;

public interface INoteService {

    List<Note> findAll();

    List<Note> findNotesById(Integer id);

    Note create(Note note);

    public Note update(String id, Note note);

    void delete(String id);
}
