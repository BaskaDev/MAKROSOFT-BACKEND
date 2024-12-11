package co.company.makrosoft.apirest.preuba.service;

import co.company.makrosoft.apirest.preuba.entity.Movie;
import co.company.makrosoft.apirest.preuba.entity.Copy;
import co.company.makrosoft.apirest.preuba.repository.MovieRepository;
import co.company.makrosoft.apirest.preuba.repository.CopyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private CopyRepository copyRepository;


    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    // Método para buscar películas por nombre o descripción
    public List<Movie> searchMovies(String keyword) {

        List<Movie> movies = movieRepository.findMovieByMovieNameContainingIgnoreCase(keyword);


        for (Movie movie : movies) {
            int availableCopies = (int) copyRepository.findByMovieMovieId(movie.getMovieId()).stream()
                    .filter(Copy::isCopyState)
                    .count();

        }

        return movies;
    }
}
