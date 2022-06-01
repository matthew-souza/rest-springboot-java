package br.com.movies.controller;

import br.com.movies.model.Movie;
import br.com.movies.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {

    @Autowired
    MovieRepository repository;

    @GetMapping("/movies")
    ResponseEntity<List<Movie>> getAllMovies(@RequestParam(required = false) String title) {

        var movies = new ArrayList<Movie>();

        if (title == null) repository.findAll().forEach(movies::add);
        else repository.findNonExactTitle(title.toLowerCase()).forEach(movies::add);

        if (movies.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return ResponseEntity.ok(movies);
    }

    @PostMapping("/movies")
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
        return ResponseEntity.ok(repository.save(Movie.builder()
                .title(movie.getTitle())
                .synopsis(movie.getSynopsis())
                .director(movie.getDirector())
                .build()));
    }
}
