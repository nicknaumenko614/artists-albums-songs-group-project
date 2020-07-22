package org.wcci.apimastery.controllers;

import org.springframework.web.bind.annotation.*;
import org.wcci.apimastery.entities.*;
import org.wcci.apimastery.repositories.SongRepository;
import org.wcci.apimastery.storage.AlbumStorage;
import org.wcci.apimastery.storage.CommentStorage;
import org.wcci.apimastery.storage.SongStorage;

import java.util.Collection;

@CrossOrigin
@RestController
public class SongController {
    SongStorage songStorage;
    CommentStorage commentStorage;
    AlbumStorage albumStorage;

    public SongController(SongStorage songStorage, CommentStorage commentStorage, AlbumStorage albumStorage) {
        this.songStorage = songStorage;
        this.commentStorage = commentStorage;
        this.albumStorage = albumStorage;
    }

    @GetMapping("/api/songs/")
    public Collection<Song> retrieveAllSongs() {
        return songStorage.retrieveAllSongs();
    }

    @GetMapping("/api/songs/{id}")
    public Song retrieveSongById(@PathVariable long id) {
        return songStorage.retrieveSongById(id);
    }

//    @PostMapping("/api/songs/add/")
//    public Song addSong(@RequestBody Song song) {
//        return songStorage.save(song);
//    }

    @DeleteMapping("/api/songs/delete/{songId}/{albumId}")
    public Album deleteSong(@PathVariable long songId, @PathVariable long albumId) {
        songStorage.deleteSongById(songId);
        return albumStorage.retrieveAlbumById(albumId);
    }

//    @PatchMapping("/api/songs/{id}/comment/")
//    public Song addCommentToSong(@PathVariable long id, @RequestBody SongComment comment) {
//        Song song = songStorage.retrieveSongById(id);
//        SongComment commentToAdd = new SongComment(comment.getText(), comment.getAuthorName(), song);
//        commentStorage.addComment(commentToAdd);
//        return commentToAdd.getSong();
//    }


    @PatchMapping("/api/songs/{songId}/comment/")
    public Song addCommentToSong(@PathVariable long songId, @RequestBody String comment) {
        Song song = songStorage.retrieveSongById(songId);
        song.addComment(comment.toString());
        songStorage.save(song);
        return song;
    }
}