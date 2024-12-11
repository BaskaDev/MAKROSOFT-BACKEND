package co.company.makrosoft.apirest.preuba.controller;

import co.company.makrosoft.apirest.preuba.entity.Genre;
import co.company.makrosoft.apirest.preuba.service.GenreService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/genres")
@CrossOrigin
public class GenreController {

    @Autowired
    private GenreService genreService;

    @Operation(summary = "Obtener todos los géneros", description = "Retorna la lista completa de géneros disponibles.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de géneros obtenida exitosamente"),
            @ApiResponse(responseCode = "500", description = "Error en el servidor")
    })
    @GetMapping
    public ResponseEntity<List<Genre>> getAllGenres() {
        try {
            List<Genre> genres = genreService.getAllGenres();
            if (genres.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(genres);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Operation(summary = "Crear un nuevo género", description = "Crea un nuevo género y lo guarda en la base de datos.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Género creado exitosamente"),
            @ApiResponse(responseCode = "400", description = "Petición mal formada")
    })
    @PostMapping
    public ResponseEntity<Genre> createGenre(@RequestBody Genre genre) {
        try {
            Genre createdGenre = genreService.createGenre(genre);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdGenre);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @Operation(summary = "Obtener un género por ID", description = "Retorna el género correspondiente al ID proporcionado.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Género encontrado"),
            @ApiResponse(responseCode = "404", description = "Género no encontrado")
    })
    @GetMapping("/{id}")
    public Genre getGenreById(@PathVariable int id) {
        Genre genre = genreService.getGenreById(id);
        return genre;
    }

    @Operation(summary = "Actualizar un género", description = "Actualiza los detalles de un género existente.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Género actualizado exitosamente"),
            @ApiResponse(responseCode = "400", description = "Datos inválidos proporcionados"),
            @ApiResponse(responseCode = "404", description = "Género no encontrado")
    })
    @PutMapping("/{id}")
    public ResponseEntity<Genre> updateGenre(@PathVariable int id, @RequestBody Genre genreDetails) {
        try {
            Genre updatedGenre = genreService.updateGenre(id, genreDetails);
            if (updatedGenre == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(updatedGenre);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @Operation(summary = "Eliminar un género", description = "Elimina un género de la base de datos por su ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Género eliminado exitosamente"),
            @ApiResponse(responseCode = "404", description = "Género no encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGenre(@PathVariable int id) {
        try {
            boolean isDeleted = genreService.deleteGenre(id);
            if (isDeleted) {
                return ResponseEntity.noContent().build();
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
