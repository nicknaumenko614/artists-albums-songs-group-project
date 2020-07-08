package org.wcci.apimastery.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wcci.apimastery.entities.Artist;
import org.wcci.apimastery.repositories.ArtistRepository;
import org.wcci.apimastery.storage.ArtistStorage;

import java.util.Collection;

@RestController
public class ArtistController {
    ArtistStorage artistStorage;
    ArtistRepository artistRepo;

    public ArtistController(ArtistStorage artistStorage, ArtistRepository artistRepo) {
        this.artistStorage = artistStorage;
        this.artistRepo = artistRepo;
    }
    @GetMapping("/api/artist/")
    public Collection<Artist>retrieveAllArtists(){
        return artistStorage.retrieveAllArtists();
    }
}
