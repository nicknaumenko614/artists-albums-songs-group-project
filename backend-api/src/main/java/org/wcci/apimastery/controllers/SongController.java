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

    public SongController(SongStorage songStorage) {
        this.songStorage = songStorage;
    }

    @GetMapping("/api/songs/")
    public Collection<Song> retrieveAllSongs() {
        return songStorage.retrieveAllSongs();
    }
}
