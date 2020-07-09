package org.wcci.apimastery.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.Objects;

@Entity
public class Song {
    @Id
    @GeneratedValue
    private long id;
    private String songName;
    private String duration;

    @ManyToOne
    private Album album;

    public Song(String songName, String duration, Album album) {
        this.songName = songName;
        this.duration = duration;
        this.album = album;
    }

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

    public Song() {

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
