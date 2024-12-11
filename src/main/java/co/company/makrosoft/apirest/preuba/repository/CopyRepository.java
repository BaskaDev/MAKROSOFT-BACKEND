package co.company.makrosoft.apirest.preuba.repository;



import co.company.makrosoft.apirest.preuba.entity.Copy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CopyRepository extends JpaRepository<Copy, Integer> { // Cambié el tipo Long a Integer
    List<Copy> findByMovieMovieId(int movieId);

}

