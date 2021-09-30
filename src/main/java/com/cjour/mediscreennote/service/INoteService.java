package com.cjour.mediscreennote.service;

import com.cjour.mediscreennote.model.Note;
import org.bson.types.ObjectId;

import java.math.BigInteger;
import java.util.List;
import java.util.UUID;

public interface INoteService {

    List<Note> findAll();

    List<Note> findNotesById(Integer id);

    Note create(Note note);

    public Note update(ObjectId id, Note note);

    void delete(ObjectId id);
}
