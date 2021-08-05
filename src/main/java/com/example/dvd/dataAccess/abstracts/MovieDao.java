package com.example.dvd.dataAccess.abstracts;

import com.example.dvd.entities.concretes.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MovieDao extends JpaRepository<Movie,Integer> {
    @Query("FROM Movie m WHERE m.id =:id")
    Movie getMovieById(int id);

}
