package com.example.dvd.bussiness.abstracts;

import com.example.dvd.entities.concretes.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    List<Movie> listAllMovies();
    Movie addMovie(Movie movie);
    Movie getMovieById(int id);
    void deleteMovie(int id);
}
