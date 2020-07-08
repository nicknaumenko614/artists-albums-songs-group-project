package org.wcci.apimastery.storage;

import org.springframework.stereotype.Service;
import org.wcci.apimastery.entities.Album;
import org.wcci.apimastery.repositories.AlbumRepository;

import java.util.Collection;

@Service
public class AlbumStorage {
    private AlbumRepository albumRepo;

    public AlbumStorage(AlbumRepository albumRepo) {this.albumRepo = albumRepo;}
    public Album save(Album album){
        return albumRepo.save(album);
    }
    public Collection<Album> retrieveAllAlbums() {
        return(Collection<Album>) albumRepo.findAll();
    }

    public Album retrieveAlbumById(Long id){
        return albumRepo.findById(id).get();
    }
}
