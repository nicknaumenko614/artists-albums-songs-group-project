package org.wcci.apimastery.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class SongComment extends Comment {

    @JsonIgnore
    @ManyToOne
    private Song song;

    protected SongComment() {
    }

    public SongComment(String text, String authorName, Song song) {
        super(text, authorName);
        this.song = song;
    }

    public Song getSong() {
        return song;
    }
}
