package org.wcci.apimastery.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.List;

@Entity
public class Artist {
    @Id
    @GeneratedValue
    private long id;
    private String artistName;
    @OneToMany(mappedBy = "artist")
    private Collection<Album> albums;
//    @OneToMany(mappedBy = "artist")
//    private List<Song> songs;


    public Artist(String artistName) {
        this.artistName = artistName;
    }

    public Long getId() {
        return id;
    }

    public String getArtistName() {
        return artistName;
    }

    public Artist (){

    }

}

