package org.wcci.apimastery.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public abstract class Comment {

    @Id
    @GeneratedValue
    private long id;
    private String text;
    private String authorName;

    protected Comment() {
    }

    public Comment(String text, String authorName) {
        this.text = text;
        this.authorName = authorName;
    }

    public String getText() {
        return text;
    }

    public String getAuthorName() {
        return authorName;
    }
}
