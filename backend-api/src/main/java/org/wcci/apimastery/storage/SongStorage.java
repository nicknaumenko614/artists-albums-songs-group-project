package org.wcci.apimastery.storage;

import org.springframework.stereotype.Service;
import org.wcci.apimastery.entities.Song;
import org.wcci.apimastery.repositories.SongRepository;

import java.util.Collection;

@Service
public class SongStorage {
    private SongRepository songRepo;

    public SongStorage(SongRepository songRepo) {
        this.songRepo = songRepo;
    }

    public Song saveOrUpdate(Song song) {
        return songRepo.save(song);
    }

    public Collection<Song> retrieveAllSongs() {
        return (Collection<Song>) songRepo.findAll();
    }

    public Song retrieveSongById(long id) {
        return songRepo.findById(id).get();
    }

    public void deleteSongById(long id) {
        songRepo.deleteById(id);
    }

}
