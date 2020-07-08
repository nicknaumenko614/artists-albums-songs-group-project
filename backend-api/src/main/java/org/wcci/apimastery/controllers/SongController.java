package org.wcci.apimastery.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wcci.apimastery.entities.Song;
import org.wcci.apimastery.repositories.SongRepository;
import org.wcci.apimastery.storage.SongStorage;

import java.util.Collection;

@RestController
public class SongController {
    SongStorage songStorage;
    SongRepository songRepo;

    public SongController(SongStorage songStorage, SongRepository songRepo) {
        this.songStorage = songStorage;
        this.songRepo = songRepo;
    }
    @GetMapping("/api/song/")
    public Collection<Song>retrieveAllSongs(){
        return songStorage.retrieveAllSongs();
    }
}
