package org.wcci.apimastery.controllers;

import org.springframework.web.bind.annotation.*;
import org.wcci.apimastery.entities.*;
import org.wcci.apimastery.repositories.SongRepository;
import org.wcci.apimastery.storage.CommentStorage;
import org.wcci.apimastery.storage.SongStorage;

import java.util.Collection;

@RestController
public class SongController {
    SongStorage songStorage;
    CommentStorage commentStorage;

    public SongController(SongStorage songStorage, CommentStorage commentStorage) {
        this.songStorage = songStorage;
        this.commentStorage = commentStorage;
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
    public Song addSong(@RequestBody Song song) {
        return songStorage.save(song);
    }

    @DeleteMapping("/api/songs/delete/{id}")
    public Collection<Song> deleteSong(@PathVariable long id) {
        songStorage.deleteSongById(id);
        return songStorage.retrieveAllSongs();
    }

    @PatchMapping("/api/songs/{songId}/addComment/")
    public Song addCommentToSong(@PathVariable long songId, @RequestBody SongComment comment) {
        Song song = songStorage.retrieveSongById(songId);
        SongComment commentToAdd = new SongComment(comment.getText(), comment.getAuthorName(), song);
        commentStorage.addComment(commentToAdd);
        return commentToAdd.getSong();
    }


}
