package org.wcci.apimastery.controllers;

import org.springframework.web.bind.annotation.*;
import org.wcci.apimastery.entities.Album;
import org.wcci.apimastery.entities.Artist;
import org.wcci.apimastery.storage.AlbumStorage;
import org.wcci.apimastery.storage.ArtistStorage;

import java.util.Collection;

@RestController
public class AlbumController {
    AlbumStorage albumStorage;
    ArtistStorage artistStorage;

    public AlbumController(AlbumStorage albumStorage) {
        this.albumStorage = albumStorage;
    }

    @GetMapping("/api/albums/")
    public Collection<Album> retrieveAllAlbums() {
        return albumStorage.retrieveAllAlbums();
    }

    @GetMapping("/api/albums/{id}")
    public Album retrieveAlbumById(@PathVariable long id){
        return albumStorage.retrieveAlbumById(id);
    }
    @PostMapping("/api/albums/add/")
    public Album addAlbum(@RequestBody Album album){
        return albumStorage.save(album);
    }
    @DeleteMapping("/api/albums/delete/")
    public Collection<Album> deleteAlbum(@PathVariable long id) {
        albumStorage.deleteAlbumById(id);
        return albumStorage.retrieveAllAlbums();
    }
    @PatchMapping("/api/albums/{id}/addArtist/")
    public Album addArtistToAlbum(@PathVariable long id, @RequestBody Artist artist){
        Album album = albumStorage.retrieveAlbumById(id);
        Artist artistToAdd = new Artist(artist.getArtistName(), artist.getImageUrl());
        artistStorage.save(artistToAdd);

        return (Album) artistToAdd.getAlbum();
    }

//    @PatchMapping("/api/artists/{id}/addAlbum/")
//    public Artist addAlbumToArtist(@PathVariable long id, @RequestBody Album album){
//        Artist artist = artistStorage.retrieveArtistById(id);
//        Album albumToAdd = new Album(album.getAlbumName(), album.getRecordLabel(), album.getImageUrl(), album.getArtist());
//        albumStorage.save(albumToAdd);
//
//        return albumToAdd.getArtist();
//    }
}
