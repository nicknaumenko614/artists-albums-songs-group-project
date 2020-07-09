package org.wcci.apimastery.storage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.wcci.apimastery.entities.Artist;
import org.wcci.apimastery.repositories.ArtistRepository;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ArtistStorageTest {

private ArtistRepository artistRepo;
private ArtistStorage underTest;

    @BeforeEach
    void setUp(){
        artistRepo = mock(ArtistRepository.class);
        underTest = new ArtistStorage(artistRepo);
    }

    @Test
    public void shouldBeAbleToSaveNewArtist(){
        Artist testArtist = new Artist("Test Artist", "www.testurl.com");
        underTest.saveOrUpdate(testArtist);
        verify(artistRepo).save(testArtist);
    }
}
