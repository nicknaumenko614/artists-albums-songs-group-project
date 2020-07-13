package org.wcci.apimastery.controllers;

import org.springframework.web.bind.annotation.*;
import org.wcci.apimastery.entities.Album;
import org.wcci.apimastery.entities.Artist;
import org.wcci.apimastery.entities.Song;
import org.wcci.apimastery.storage.AlbumStorage;
import org.wcci.apimastery.storage.ArtistStorage;
import org.wcci.apimastery.storage.SongStorage;

import java.util.Collection;

@RestController
public class AlbumController {
    AlbumStorage albumStorage;
    SongStorage songStorage;

    public AlbumController(AlbumStorage albumStorage, SongStorage songStorage) {
        this.albumStorage = albumStorage;
        this.songStorage = songStorage;
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
    @PatchMapping("/api/albums/{id}/addSong/")
    public Album addSongToAlbum(@PathVariable long id, @RequestBody Song song){
        Album album = albumStorage.retrieveAlbumById(id);
        Song songToAdd = new Song(song.getSongName(), song.getDuration(), album, song.getImageUrl());
        songStorage.save(songToAdd);

        return songToAdd.getAlbum();
    }
}
