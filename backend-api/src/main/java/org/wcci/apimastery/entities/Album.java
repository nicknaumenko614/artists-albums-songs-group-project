package org.wcci.apimastery.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Entity
public class Album {
    @Id
    @GeneratedValue
    private long id;
    private String albumName;
    private String imageUrl;
    private String recordLabel;
    @JsonIgnore
    @ManyToOne
    private Artist artist;
    @OneToMany(mappedBy = "album", orphanRemoval = true)
    private Collection<Song> songs;
    @ElementCollection
    private List<String> comments;

    public Album() {
    }


    public Album(String albumName, String recordLabel, String imageUrl, Artist artist) {
        this.albumName = albumName;
        this.recordLabel = recordLabel;
        this.imageUrl = imageUrl;
        this.artist = artist;
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

    public Artist getArtist() {
        return artist;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Collection<Song> getSongs() {
        return songs;
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
        Album album = (Album) o;
        return id == album.id &&
                Objects.equals(albumName, album.albumName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, albumName);
    }
}

