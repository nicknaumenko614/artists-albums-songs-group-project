package org.wcci.apimastery.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.wcci.apimastery.entities.Album;
import org.wcci.apimastery.entities.Artist;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class ArtistRepositoryTest {

    @Autowired
    private ArtistRepository artistRepo;
    @Autowired
    private AlbumRepository albumRepo;
    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void artistCanHaveMultipleAlbums() {
        Artist testArtist = new Artist("Test Artist", "www.testurl.com");
        artistRepo.save(testArtist);
        Album album1 = new Album("Vulnicara", "Capital", "www.google.com", testArtist);
        Album album2 = new Album("Francis", "Columbia", "www.google.com", testArtist);
        albumRepo.save(album1);
        albumRepo.save(album2);
        entityManager.flush();
        entityManager.clear();

        Artist retrievedArtist = artistRepo.findById(testArtist.getId()).get();
        assertThat(retrievedArtist).isEqualTo(testArtist);
        assertThat(retrievedArtist.getAlbums()).containsExactlyInAnyOrder(album1, album2);
    }

    @Test
    public void saveShouldBeAbleToUpdateArtistInfo() {
        Artist testArtist = new Artist("Test Artist", "www.testurl.com");
        artistRepo.save(testArtist);
//        Album album1 = new Album("Vulnicara", "Capital", "www.google.com", testArtist);
//        Album album2 = new Album("Francis", "Columbia", "www.google.com", testArtist);
//        albumRepo.save(album1);
//        albumRepo.save(album2);

        String newArtistName = "New arbitrary name";
        testArtist.setArtistName(newArtistName);
        artistRepo.save(testArtist);
        entityManager.flush();
        entityManager.clear();

        Artist retrievedArtist = artistRepo.findById(testArtist.getId()).get();
        assertThat(retrievedArtist.getArtistName()).isEqualTo(newArtistName);

    }
}
