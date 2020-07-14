package org.wcci.apimastery.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class ArtistComment extends Comment {

    @JsonIgnore
    @ManyToOne
    private Artist artist;

    protected ArtistComment() { }

    public ArtistComment(String text, String authorName, Artist artist) {
        super(text, authorName);
        this.artist = artist;
    }

    public Artist getArtist() {
        return artist;
    }
}
