package com.cjour.mediscreennote.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;

@Document(collection ="notes")
public class Note {

    @Id
    private BigInteger ID;
    private Integer patId;
    //private Date creationDate;
    private String description;

    public Note() {}

    public Note(BigInteger ID, Integer patId, String description) {
        this.ID = ID;
        this.patId = patId;
        this.description = description;
    }

    public BigInteger getID() {
        return ID;
    }

    public void setID(BigInteger ID) {
        this.ID = ID;
    }

    public Integer getPatId() {
        return patId;
    }

    public void setPatId(Integer patId) {
        this.patId = patId;
    }

//    public Date getCreationDate() {
//        return creationDate;
//    }
//
//    public void setCreationDate(Date creationDate) {
//        this.creationDate = creationDate;
//    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
