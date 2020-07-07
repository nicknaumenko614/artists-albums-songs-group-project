package org.wcci.apimastery.storage;

import org.springframework.stereotype.Service;
import org.wcci.apimastery.repositories.AlbumRepository;

@Service
public class AlbumStorage {
    private AlbumRepository albumRepo;

    public AlbumStorage(AlbumRepository albumRepo) {this.albumRepo = albumRepo;}

}
