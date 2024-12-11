package co.company.makrosoft.apirest.preuba.repository;



import co.company.makrosoft.apirest.preuba.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
    List<Movie> findMovieByMovieNameContainingIgnoreCase(String movieName);
}
