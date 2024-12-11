package co.company.makrosoft.apirest.preuba.service;

import co.company.makrosoft.apirest.preuba.entity.Genre;
import co.company.makrosoft.apirest.preuba.repository.GenreRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GenreServiceTest {

    @Mock
    private GenreRepository genreRepository;

    @InjectMocks
    private GenreService genreService;
    private Optional<Genre> genreId;

    private Genre genre;
    private Genre genreUpdate;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        genre = new Genre();
        genre.setGenreId(1);
        genre.setGenreName("Comedia");
        genre.setGenreRentalPrice(10000);

        Optional<Genre> genreId = Optional.of(genre);

    }

    @Test
    void getAllGenres() {

        when(genreRepository.findAll()).thenReturn(Arrays.asList(genre));
        assertNotNull(genreService.getAllGenres());
    }


    @Test
    void createGenre() {

        when(genreRepository.save(genre)).thenReturn(genre);
        assertNotNull(genreService.createGenre(genre));
    }


    @Test
    void getGenreById() {

        when(genreRepository.findById(genre.getGenreId())).thenReturn(genre);

        Genre result = genreService.getGenreById(genre.getGenreId());
        assertNotNull(result);
        assertEquals(genre, result);
    }


    @Test
    void updateGenre() {

        Genre genreUpdate = new Genre();
        genreUpdate.setGenreId(1);
        genreUpdate.setGenreName("Comedia");
        genreUpdate.setGenreRentalPrice(30000);


        Genre genreFromRepo = new Genre();
        genreFromRepo.setGenreId(1);
        genreFromRepo.setGenreName("Acción");
        genreFromRepo.setGenreRentalPrice(20000);


        when(genreRepository.findById(1)).thenReturn(genreFromRepo);

        when(genreRepository.save(genreFromRepo)).thenReturn(genreUpdate);


        Genre result = genreService.updateGenre(1, genreUpdate);


        assertNotNull(result);
        assertEquals(genreUpdate, result);
    }




    @Test
    void deleteGenre() {

        Genre genre = new Genre();
        genre.setGenreId(1);
        genre.setGenreName("Comedia");
        genre.setGenreRentalPrice(30000);


        when(genreRepository.existsById(1)).thenReturn(true);
        doNothing().when(genreRepository).deleteById(1);


        boolean result = genreService.deleteGenre(1);


        assertTrue(result);
        verify(genreRepository).deleteById(1);


        when(genreRepository.existsById(2)).thenReturn(false);


        result = genreService.deleteGenre(2);


        assertFalse(result);
        verify(genreRepository, times(0)).deleteById(2);
    }

}