package co.company.makrosoft.apirest.preuba.repository;




import co.company.makrosoft.apirest.preuba.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Integer> {

    public  Genre findById(int id);
}
