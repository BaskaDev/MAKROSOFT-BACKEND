package co.company.makrosoft.apirest.preuba.entity;

import jakarta.persistence.*;


@Entity

public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int genreId;
    private String genreName;
    private int genreRentalPrice;

    // Getters y setters
    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public int getGenreRentalPrice() {
        return genreRentalPrice;
    }

    public void setGenreRentalPrice(int genreRentalPrice) {
        this.genreRentalPrice = genreRentalPrice;
    }
}