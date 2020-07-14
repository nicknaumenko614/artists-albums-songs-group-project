package org.wcci.apimastery.controllers;

import org.springframework.web.bind.annotation.*;
import org.wcci.apimastery.entities.*;
import org.wcci.apimastery.repositories.ArtistRepository;
import org.wcci.apimastery.storage.AlbumStorage;
import org.wcci.apimastery.storage.ArtistStorage;
import org.wcci.apimastery.storage.CommentStorage;

import java.util.Collection;

@RestController
public class ArtistController {
    ArtistStorage artistStorage;
    AlbumStorage albumStorage;
    CommentStorage commentStorage;

    public ArtistController(ArtistStorage artistStorage, AlbumStorage albumStorage, CommentStorage commentStorage) {
        this.artistStorage = artistStorage;
        this.albumStorage = albumStorage;
        this.commentStorage = commentStorage;
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
        Album albumToAdd = new Album(album.getAlbumName(), album.getRecordLabel(), album.getImageUrl(), artist);
        albumStorage.save(albumToAdd);

        return albumToAdd.getArtist();
    }

    @PatchMapping("/api/artists/{id}/addComment/")
    public Artist addCommentToArtist(@PathVariable long id, @RequestBody ArtistComment comment) {
        Artist artist = artistStorage.retrieveArtistById(id);
        ArtistComment commentToAdd = new ArtistComment(comment.getText(), comment.getAuthorName(), artist);
        commentStorage.addComment(commentToAdd);
        return commentToAdd.getArtist();
    }

    @DeleteMapping("/api/artists/delete/{id}")
    public Collection<Artist> deleteArtist(@PathVariable long id) {
        artistStorage.deleteArtistById(id);
        return artistStorage.retrieveAllArtists();
    }
}