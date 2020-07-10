package org.wcci.apimastery.controllers;

import org.springframework.web.bind.annotation.*;
import org.wcci.apimastery.entities.Album;
import org.wcci.apimastery.entities.Artist;
import org.wcci.apimastery.repositories.ArtistRepository;
import org.wcci.apimastery.storage.AlbumStorage;
import org.wcci.apimastery.storage.ArtistStorage;

import java.util.Collection;

@RestController
public class ArtistController {
    ArtistStorage artistStorage;
    AlbumStorage albumStorage;

    public ArtistController(ArtistStorage artistStorage) {
        this.artistStorage = artistStorage;
    }

    @GetMapping("/api/artists/")
    public Collection<Artist> retrieveAllArtists() {
        return artistStorage.retrieveAllArtists();
    }


    @GetMapping("/api/artists/{id}")
    public Artist retrieveArtistById(@PathVariable long id) {
        return artistStorage.retrieveArtistById(id);
    }
    @PostMapping("/api/artists/add/")
    public Artist addArtist(@RequestBody Artist artist){
        return artistStorage.save(artist);
    }

    @PatchMapping("/api/artists/{id}/addAlbum/")
    public Artist addAlbumToArtist(@PathVariable long id, @RequestBody Album album){
        Artist artist = artistStorage.retrieveArtistById(id);
        Album albumToAdd = new Album(album.getAlbumName(), album.getRecordLabel(), album.getImageUrl(), album.getArtist());
        albumStorage.save(albumToAdd);

        return albumToAdd.getArtist();
    }

    @DeleteMapping("/api/artists/delete/")
    public Collection<Artist> deleteArtist(@PathVariable long id) {
        artistStorage.deleteArtistById(id);
        return artistStorage.retrieveAllArtists();
    }
}