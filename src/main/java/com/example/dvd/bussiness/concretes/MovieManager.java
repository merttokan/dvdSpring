package com.example.dvd.bussiness.concretes;

import com.example.dvd.bussiness.abstracts.MovieService;
import com.example.dvd.dataAccess.abstracts.MovieDao;
import com.example.dvd.entities.concretes.Movie;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieManager implements MovieService {

    private MovieDao movieDao;


    public MovieManager(MovieDao movieDao) {
        super();
        this.movieDao = movieDao;
    }
    @Override
    public List<Movie> listAllMovies() {
        return this.movieDao.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    @Override
    public Movie addMovie(Movie movie) {
        return this.movieDao.save(movie);
    }

    @Override
    public Movie getMovieById(int id) {
        return this.movieDao.getMovieById(id);
    }

    @Override
    public void deleteMovie(int id) {
        this.movieDao.deleteById(id);
    }
}
