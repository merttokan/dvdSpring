package com.example.dvd.bussiness.abstracts;

import com.example.dvd.entities.concretes.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> listAllMovies();
    Movie addMovie(Movie movie);
}
