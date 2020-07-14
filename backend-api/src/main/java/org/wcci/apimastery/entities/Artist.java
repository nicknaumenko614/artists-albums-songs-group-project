package org.wcci.apimastery.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Artist {
    @Id
    @GeneratedValue
    private long id;
    private String artistName;
    private String imageUrl;
    @OneToMany(mappedBy = "artist", orphanRemoval = true)
    private Collection<Album> albums;
    @OneToMany(mappedBy = "artist", orphanRemoval = true)
    private Collection<ArtistComment> comments;


    public Artist() {
    }


    public Artist(String artistName, String imageUrl) {
        this.artistName = artistName;
        this.imageUrl = imageUrl;
    }


    public Long getId() {
        return id;
    }

    public String getArtistName() {
        return artistName;
    }

    public Collection<Album> getAlbums() {
        return albums;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Collection<ArtistComment> getComments() {
        return comments;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Artist artist = (Artist) o;
        return id == artist.id &&
                Objects.equals(artistName, artist.artistName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, artistName);
    }

}

