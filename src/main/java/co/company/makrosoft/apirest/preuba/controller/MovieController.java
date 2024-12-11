package co.company.makrosoft.apirest.preuba.controller;



import co.company.makrosoft.apirest.preuba.entity.Movie;
import co.company.makrosoft.apirest.preuba.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
@CrossOrigin

public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/buscar")
    public ResponseEntity<List<Movie>> searchMovies(@RequestParam String keyword) {
        List<Movie> movies = movieService.searchMovies(keyword);
        if (movies.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(movies);
    }

    @GetMapping
    public ResponseEntity<List<Movie>> searchMovies() {
        List<Movie> movies = movieService.getAllMovies();
        if (movies.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(movies);
    }


}
