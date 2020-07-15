package org.wcci.apimastery.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity

public class Comment {

    @Id
    @GeneratedValue
    private long id;
    private String text;
    private String authorName;
    @ManyToOne
    private Song song;

    protected Comment() {
    }

    public Comment(String text, String authorName, Song song) {
        this.text = text;
        this.authorName = authorName;
        this.song = song;
    }

    public String getText() {
        return text;
    }

    public String getAuthorName() {
        return authorName;
    }

    public Song getSong() {
        return song;
    }
}
