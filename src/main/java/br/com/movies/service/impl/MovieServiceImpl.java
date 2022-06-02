package br.com.movies.service.impl;

import br.com.movies.model.Movie;
import br.com.movies.repository.MovieRepository;
import br.com.movies.service.MovieService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository repository;

    private final Logger logger = Logger.getLogger(this.getClass());

    @Override
    public List<Movie> findAllMovies(String title) {
        var movies = new ArrayList<Movie>();

        if (title == null)
            repository.findAll().forEach(movies::add);
        else
            repository.findNonExactTitle(title.toLowerCase()).forEach(movies::add);

        return movies;
    }

    @Override
    public Movie createMovie(Movie movie) {
        return repository.save(Movie.builder()
                .title(movie.getTitle())
                .synopsis(movie.getSynopsis())
                .director(movie.getDirector())
                .build());
    }

    @Override
    public boolean deleteMovie(long id) {

        try {
            repository.deleteById(id);
            return true;
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return false;
    }
}
