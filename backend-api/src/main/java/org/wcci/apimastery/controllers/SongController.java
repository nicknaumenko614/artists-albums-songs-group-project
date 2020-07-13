package org.wcci.apimastery.controllers;

import org.springframework.web.bind.annotation.*;
import org.wcci.apimastery.entities.Album;
import org.wcci.apimastery.entities.Artist;
import org.wcci.apimastery.entities.Comment;
import org.wcci.apimastery.entities.Song;
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
    public Song addSong(@RequestBody Song song){
        return songStorage.save(song);
    }

    @DeleteMapping("/api/songs/delete/")
    public Collection<Song> deleteSong(@PathVariable long id) {
        songStorage.deleteSongById(id);
        return songStorage.retrieveAllSongs();
    }

    @PostMapping("/api/comments/add/")
    public Comment addComment(@RequestBody long songId,String authorName, String commentText){
        Song song = songStorage.retrieveSongById(songId);
        Comment commentToAdd = new Comment(authorName, commentText, song);
        commentStorage.addComment(commentToAdd);
        return commentStorage.addComment();
    }

//    @PostMapping("/bens/comments/add")
//    public String addComment(long songId, String authorName, String commentText) {
//        Song song = songStorage.retrieveSongById(songId);
//        Comment commentToAdd = new Comment( long id, song, String authorName   );
//        commentStorage.addComment(commentToAdd);
//        return "redirect:/bens/" + ben.getName();
//    }

}
