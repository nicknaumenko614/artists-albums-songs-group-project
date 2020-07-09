package org.wcci.apimastery.controllers;

import org.springframework.web.bind.annotation.*;
import org.wcci.apimastery.entities.Artist;
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

    @GetMapping("/api/songs/{id}")
    public Song retrieveSongById(@PathVariable long id) {
        return songStorage.retrieveSongById(id);
    }

    @PostMapping("/api/songs/add/")
    public Song addSong(@RequestBody Song song){
        return songStorage.save(song);
    }
    @DeleteMapping("/api/songs/delete/")
    public Collection<Song> deleteSong(@PathVariable long id) {
        songStorage.deleteSongById(id);
        return songStorage.retrieveAllSongs();
    }
}
