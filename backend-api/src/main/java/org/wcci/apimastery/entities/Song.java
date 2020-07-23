package org.wcci.apimastery.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
public class Song {
    @Id
    @GeneratedValue
    private long id;
    private String songName;
    private String duration;
    private String imageUrl;
    @JsonIgnore
    @ManyToOne
    private Album album;
    @ElementCollection
    private List<String> comments;

    public Song(String songName, String duration, Album album, String imageUrl) {
        this.songName = songName;
        this.duration = duration;
        this.album = album;
        this.imageUrl = imageUrl;
    }

    public Song() {}

    public Long getId() {
        return id;
    }

    public String getSongName() {
        return songName;
    }

    public String getDuration() {
        return duration;
    }

    public Album getAlbum() {
        return album;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public List<String> getComments() {
        return comments;
    }




    public void addComment(String comment){
        if(comments==null){
            comments=new ArrayList<>();
        }
        comments.add(comment);
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return id == song.id &&
                Objects.equals(songName, song.songName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, songName);
    }
}
