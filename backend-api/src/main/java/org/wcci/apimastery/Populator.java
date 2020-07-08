package org.wcci.apimastery;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wcci.apimastery.entities.Album;
import org.wcci.apimastery.entities.Artist;
import org.wcci.apimastery.repositories.AlbumRepository;
import org.wcci.apimastery.repositories.ArtistRepository;
import org.wcci.apimastery.repositories.SongRepository;
import org.wcci.apimastery.storage.ArtistStorage;

@Component
public class Populator implements CommandLineRunner {
    SongRepository songRepo;
    ArtistRepository artistRepo;
    AlbumRepository albumRepo;

    @Override
    public void run(String... args) throws Exception {
        Artist artist1 = new Artist("Bjork");
        Artist artist2 = new Artist("The Mars Volta");
        artistRepo.save(artist1);
        artistRepo.save(artist2);
        Album album1 = new Album("Vulnicara","Capital");
        Album album2 = new Album("Francis", "Columbia");
        albumRepo.save(album1);
        albumRepo.save(album2);
    }

}