package br.com.movies.service;

import br.com.movies.model.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MovieService {

    List<Movie> findAllMovies(String title);

    Movie createMovie(Movie movie);

    boolean deleteMovie(long id);
}
