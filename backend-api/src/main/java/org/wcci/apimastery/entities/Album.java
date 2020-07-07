package org.wcci.apimastery.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Album {
    @Id
    @GeneratedValue
    private Long id;
    private String albumName;
    private String recordLabel;
    @ManyToOne
    private Artist artist;
    @OneToMany(mappedBy = "album")
    private List<Song> songs;


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

