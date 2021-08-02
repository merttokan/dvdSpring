package com.example.dvd.controller;


import com.example.dvd.bussiness.abstracts.ArtistService;
import com.example.dvd.bussiness.abstracts.MovieService;

import com.example.dvd.entities.concretes.Artist;
import com.example.dvd.entities.concretes.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller

public class UnitedController {

    private final MovieService movieService;
    private final ArtistService artistService;

    @Autowired
    public UnitedController(MovieService movieService, ArtistService artistService) {
        this.movieService = movieService;
        this.artistService = artistService;
    }

    @GetMapping("/movies")
    private String moviesList(Model model) {
       model.addAttribute("movies",movieService.listAllMovies());
       return "index";
    }

    @RequestMapping("/add")
    private String addMovie(
                            Model model
                            ) {
        Movie movie = new Movie();

        model.addAttribute("adder", movie);

        return "adder";
    }
    @PostMapping("/add/save")
    public String saveMovies(@ModelAttribute Movie movie,Model model){
        model.addAttribute("adder", this.movieService.addMovie(movie));

        return "redirect:/add";
    }
    @GetMapping("/artists")
    private String artistsList(Model model){
        model.addAttribute("artists",artistService.listAllArtists());
        return "indexx";
    }
    @RequestMapping("/addArtist")
    private String addArtist(
            Model model
    ) {
        Artist artist = new Artist();

        model.addAttribute("addArtist", artist);

        return "addArtist";
    }
    @PostMapping("/addArtist/save")
    public String saveArtists(@ModelAttribute Artist artist,Model model){
        model.addAttribute("addArtist", this.artistService.addArtist(artist));

        return "redirect:/addArtist";
    }



}
