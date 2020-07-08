package org.wcci.apimastery.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wcci.apimastery.entities.Album;
import org.wcci.apimastery.repositories.AlbumRepository;
import org.wcci.apimastery.storage.AlbumStorage;

import java.util.Collection;

@RestController
public class AlbumController {
    AlbumStorage albumStorage;
    AlbumRepository albumRepo;

    public AlbumController(AlbumStorage albumStorage, AlbumRepository albumRepo){
        this.albumStorage = albumStorage;
        this.albumRepo = albumRepo;
    }
    @GetMapping("/api/album/")
    public Collection<Album> retrieveAllAlbums(){
        return albumStorage.retrieveAllAlbums();
    }

}
