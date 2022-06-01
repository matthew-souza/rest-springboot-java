package br.com.movies.repository;

import br.com.movies.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query("SELECT u FROM Movie u WHERE LOWER(u.title) LIKE %:title%")
    List<Movie> findNonExactTitle(@Param("title") String title);
}
