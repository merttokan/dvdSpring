package com.example.dvd.bussiness.concretes;

import com.example.dvd.bussiness.abstracts.MovieService;
import com.example.dvd.dataAccess.abstracts.MovieDao;
import com.example.dvd.entities.concretes.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieManager implements MovieService {

    private MovieDao movieDao;


    public MovieManager(MovieDao movieDao) {
        super();
        this.movieDao = movieDao;
    }
    @Override
    public List<Movie> listAllMovies() {
        return this.movieDao.findAll();
    }

    @Override
    public Movie addMovie(Movie movie) {
        return this.movieDao.save(movie);
    }
}
