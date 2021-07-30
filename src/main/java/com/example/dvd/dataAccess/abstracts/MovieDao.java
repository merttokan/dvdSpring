package com.example.dvd.dataAccess.abstracts;

import com.example.dvd.entities.concretes.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieDao extends JpaRepository<Movie,Integer> {
}
