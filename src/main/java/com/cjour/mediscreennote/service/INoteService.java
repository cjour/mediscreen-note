package com.cjour.mediscreennote.service;

import com.cjour.mediscreennote.model.Note;

import java.util.List;
import java.util.UUID;

public interface INoteService {

    List<Note> findAll();

    List<Note> findNotesById(UUID id);

    Note create(Note note);
}
