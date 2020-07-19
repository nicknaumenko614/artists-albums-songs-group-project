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
        Artist artist1 = new Artist("Bjork", "https://res.cloudinary.com/electronic-beats/stage/uploads/2015/03/Bjork_EB.jpg");
        Artist artist2 = new Artist("The Mars Volta", "https://exclaim.ca/images/mars_volta_19.jpg");
        Artist artist3 = new Artist("Test Artist", "https://www.bocadolobo.com/blog/wp-content/uploads/2018/06/Vincent-van-Gogh.jpg");
        artistRepo.save(artist1);
        artistRepo.save(artist2);
        artistRepo.save(artist3);
        Album album1 = new Album("Vulnicara", "Capital", "https://www.bjork.fr/IMG/jpg/bjork-2015-inez-vinoodh-vulnicura-10.jpg", artist1);
        Album album2 = new Album("Francis", "Columbia", "https://www.rockarchive.com/media/1361/the-mars-volta-mvol002st.jpg?width=800&height=803&mode=stretch&overlay=watermark.png&overlay.size=230,20&overlay.position=0,783", artist2);
        Album album3 = new Album("Test Album", "Test Label", "https://www.bocadolobo.com/blog/wp-content/uploads/2018/06/Vincent-van-Gogh.jpg", artist3);
        albumRepo.save(album1);
        albumRepo.save(album2);
        albumRepo.save(album3);
        Song song1 = new Song("Stonemilker", "4:20", album1, "https://www.youtube.com/embed/gQEyezu7G20");
        Song song2 = new Song("Cygnus", "3:79", album2, "https://www.youtube.com/embed/zuQWN9ehfrk");
        Song song3 = new Song("Test Song", "3:79", album3, "Cygnus.com");
        songRepo.save(song1);
        songRepo.save(song2);
        songRepo.save(song3);
    }

}