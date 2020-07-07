package org.wcci.apimastery.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Album {
    @Id
    @GeneratedValue
    private Long id;
    private String albumName;
    private String recordLabel;

    public Album(String albumName, String recordLabel) {
        this.albumName = albumName;
        this.recordLabel = recordLabel;
    }

    public Long getId() {
        return id;
    }

    public String getAlbumName() {
        return albumName;
    }

    public String getRecordLabel() {
        return recordLabel;
    }

    public Album(){

    }
}

