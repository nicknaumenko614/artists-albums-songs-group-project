package org.wcci.apimastery.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Song {
    @Id
    @GeneratedValue
    private Long id;
    private String songName;
    private String duration;

    @ManyToOne
    private Artist artist;
    @ManyToOne
    private Album album;

    public Song(String songName, String duration, Artist artist, Album album) {
        this.songName = songName;
        this.duration = duration;
        this.artist = artist;
        this.album = album;
    }

    public Long getId(){
        return id;
    }

    public String getSongName() {
        return songName;
    }

    public String getDuration() {
        return duration;
    }

    public Artist getArtist() {
        return artist;
    }

    public Album getAlbum() {
        return album;
    }

    public Song(){

    }
}
