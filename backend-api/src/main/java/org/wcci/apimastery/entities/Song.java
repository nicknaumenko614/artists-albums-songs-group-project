package org.wcci.apimastery.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Song {
    @Id
    @GeneratedValue
    private Long id;
    private String songName;
    private String duration;

    public Song(String songName, String duration) {
        this.songName = songName;
        this.duration = duration;
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

    public Song(){

    }
}
