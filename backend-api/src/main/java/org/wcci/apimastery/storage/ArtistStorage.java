package org.wcci.apimastery.storage;

import org.springframework.stereotype.Service;
import org.wcci.apimastery.entities.Artist;
import org.wcci.apimastery.repositories.ArtistRepository;

import java.util.Collection;

@Service
public class ArtistStorage {
    private ArtistRepository artistRepo;
    public ArtistStorage(ArtistRepository artistRepo){
        this.artistRepo = artistRepo;
    }
public Artist save (Artist artist){
        return artistRepo.save(artist);
}
public Collection<Artist> retrieveAllArtists(){
        return (Collection<Artist>) artistRepo.findAll();
}
public Artist retrieveArtistById (long id){
        return artistRepo.findById(id).get();
}
}
