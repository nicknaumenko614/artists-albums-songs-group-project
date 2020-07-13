package org.wcci.apimastery.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class AlbumComment extends Comment {

    @JsonIgnore
    @ManyToOne
    private Album album;

    protected AlbumComment() {
    }

    public AlbumComment(String text, String authorName, Album album) {
        super(text, authorName);
        this.album = album;
    }

    public Album getAlbum() {
        return album;
    }
}
