package org.wcci.apimastery.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
public class Album {
    @Id
    @GeneratedValue
    private long id;
    private String albumName;
    private String recordLabel;
    @ManyToOne
    private Artist artist;
    @OneToMany(mappedBy = "album")
    private Collection<Song> songs;



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

