package co.company.makrosoft.apirest.preuba.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Copy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int copyId;

    private String copyCode;

    private boolean copyState;

    @ManyToOne
    @JoinColumn(name = "fk_movie_id", referencedColumnName = "movieId")
    private Movie movie;

    // Getters y Setters
    public int getCopyId() {
        return copyId;
    }

    public void setCopyId(int copyId) {
        this.copyId = copyId;
    }

    public String getCopyCode() {
        return copyCode;
    }

    public void setCopyCode(String copyCode) {
        this.copyCode = copyCode;
    }

    public boolean isCopyState() {
        return copyState;
    }

    public void setCopyState(boolean copyState) {
        this.copyState = copyState;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
