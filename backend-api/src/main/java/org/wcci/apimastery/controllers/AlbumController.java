package org.wcci.apimastery.controllers;

import org.springframework.web.bind.annotation.*;
import org.wcci.apimastery.entities.Album;
import org.wcci.apimastery.storage.AlbumStorage;

import java.util.Collection;

@RestController
public class AlbumController {
    AlbumStorage albumStorage;

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

}
