package org.wcci.apimastery.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.wcci.apimastery.entities.Album;
import org.wcci.apimastery.entities.Artist;
import org.wcci.apimastery.entities.Song;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class AlbumRepositoryTest {

    @Autowired
    private SongRepository songRepo;
    @Autowired
    private AlbumRepository albumRepo;
    @Autowired
    private ArtistRepository artistRepo;
    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void albumCanHaveManySongs() {
        Artist testArtist = new Artist("Test Artist", "www.testurl.com");
        Album testAlbum = new Album("Test Album", "Test Label", "www.testurl.com", testArtist);
        Song testSong1 = new Song ("Test Song", "2:00", testAlbum);
        Song testSong2 = new Song ("Another Test Song", "3:00", testAlbum);
        artistRepo.save(testArtist);
        albumRepo.save(testAlbum);
        songRepo.save(testSong1);
        songRepo.save(testSong2);

        entityManager.flush();
        entityManager.clear();

        Album retrievedAlbum = albumRepo.findById(testAlbum.getId()).get();
        assertThat(retrievedAlbum).isEqualTo(testAlbum);
        assertThat(retrievedAlbum.getSongs()).containsExactlyInAnyOrder(testSong1, testSong2);
    }
}
