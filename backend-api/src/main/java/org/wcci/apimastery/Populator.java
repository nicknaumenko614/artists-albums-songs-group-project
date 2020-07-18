package org.wcci.apimastery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.wcci.apimastery.entities.Album;
import org.wcci.apimastery.entities.Artist;
import org.wcci.apimastery.entities.Song;
import org.wcci.apimastery.repositories.AlbumRepository;
import org.wcci.apimastery.repositories.ArtistRepository;
import org.wcci.apimastery.repositories.SongRepository;
import org.wcci.apimastery.storage.ArtistStorage;

@Component
public class Populator implements CommandLineRunner {
    @Autowired
    SongRepository songRepo;
    @Autowired
    ArtistRepository artistRepo;
    @Autowired
    AlbumRepository albumRepo;

    @Override
    public void run(String... args) throws Exception {
        Artist artist1 = new Artist("Bjork", "www.artist1.com");
        Artist artist2 = new Artist("The Mars Volta", "www.artist2.com");
        Artist artist3 = new Artist("Arbitrary Artist", "www.artist3.com");
        artistRepo.save(artist1);
        artistRepo.save(artist2);
        artistRepo.save(artist3);
        Album album1 = new Album("Vulnicara", "Capital", "www.album1.com", artist1);
        Album album2 = new Album("Francis", "Columbia", "www.album2.com", artist2);
        Album album3 = new Album("Arbitrary Album", "Arbitrary Lable", "www.album3.com", artist3);
        albumRepo.save(album1);
        albumRepo.save(album2);
        albumRepo.save(album3);
        Song song1 = new Song("Stonemilker", "4:20", album1, "stonemilker.com");
        Song song2 = new Song("Cygnus", "3:79", album2, "Cygnus.com");
        Song song3 = new Song("Arbitrary Song", "3:79", album3, "Cygnus.com");
        songRepo.save(song1);
        songRepo.save(song2);
        songRepo.save(song3);
    }

}