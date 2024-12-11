package co.company.makrosoft.apirest.preuba.service;

import co.company.makrosoft.apirest.preuba.entity.Genre;
import co.company.makrosoft.apirest.preuba.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreService {

    @Autowired
    private GenreRepository genreRepository;

    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }


    public Genre createGenre(Genre genre) {
        return genreRepository.save(genre);
    }


    public Genre getGenreById(int id) {
        return genreRepository.findById(id);
    }

    public Genre updateGenre(int id, Genre genreDetails) {
        Genre g = genreRepository.findById(id);
        if (g != null) {
            Genre genre = g;
            genre.setGenreName(genreDetails.getGenreName());
            genre.setGenreRentalPrice(genreDetails.getGenreRentalPrice());
            return genreRepository.save(genre);
        }
        return null;
    }

    public boolean deleteGenre(int id) {
        if (genreRepository.existsById(id)) {
            genreRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
