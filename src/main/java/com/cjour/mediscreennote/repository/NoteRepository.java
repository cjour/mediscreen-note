package com.cjour.mediscreennote.repository;

import com.cjour.mediscreennote.model.Note;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface NoteRepository extends MongoRepository<Note, String> {
    //Note updateNoteById(String id, Note note);
    void deleteById(String id);
    List<Note> findByPatId(int id);
}
