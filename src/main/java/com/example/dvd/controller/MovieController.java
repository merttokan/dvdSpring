package com.example.dvd.controller;


import com.example.dvd.bussiness.abstracts.MovieService;

import com.example.dvd.entities.concretes.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller

public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/list")
    private String moviesList(Model model) {
       model.addAttribute("movies",movieService.listAllMovies());
       return "index";
    }
    @RequestMapping("/add")
    private String addMovie(@ModelAttribute Movie movie,
                            Model model
                            ) {
        model.addAttribute("adder", this.movieService.addMovie(movie));

        return "adder";
    }



}
