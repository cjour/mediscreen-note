package com.cjour.mediscreennote.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection ="notes")
public class Note {

    @Id
    private ObjectId id;
    private Integer patId;
    private String description;

    public Note() {}

    public Note(ObjectId id, Integer patId, String description) {
        this.id = id;
        this.patId = patId;
        this.description = description;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public Integer getPatId() {
        return patId;
    }

    public void setPatId(Integer patId) {
        this.patId = patId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
