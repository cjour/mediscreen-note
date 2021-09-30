package com.cjour.mediscreennote.repository;

import com.cjour.mediscreennote.model.Note;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends MongoRepository<Note, ObjectId> {
    //Note updateNoteById(String id, Note note);
    void deleteById(ObjectId id);
    List<Note> findByPatId(int id);
}
