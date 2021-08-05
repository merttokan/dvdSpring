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
       return "movies";
    }
    @RequestMapping(value = "/deleteMovie/{id}",method = RequestMethod.GET)
    private String deleteMovie(@PathVariable String id){
        movieService.deleteMovie(Integer.parseInt(id));
        return "redirect:/movies";
    }

    @RequestMapping(value = "/addMovie/{id}",method = RequestMethod.GET)
    private String addMovie(@PathVariable(required = false) String id,
                            Model model
                            ) {
        Movie movie = new Movie();
        if(id != null){
            movie = movieService.getMovieById(Integer.parseInt(id));
        }

        model.addAttribute("adder", movieService.addMovie(movie));

        return "addMovie";
    }
    @RequestMapping("/addMovie")
    public String saveMovies(@ModelAttribute Movie movie,Model model){
        model.addAttribute("adder", this.movieService.addMovie(movie));

        return "/addMovie";
    }
  /*  @GetMapping("/addMovie/{id}")
    private String editMovie(@RequestParam int id, Model model){
        model.addAttribute("movieId",movieService.editMovie(id));

        return "addMovie";
    }*/
    @GetMapping("/artists")
    private String artistsList(Model model){
        model.addAttribute("artists",artistService.listAllArtists());
        return "artists";
    }

    @RequestMapping(value = "/addArtist/{id}",method = RequestMethod.GET)
    private String addArtist(@PathVariable(required = false) String id,
                            Model model
    ) {
        Artist artist = new Artist();
        if(id != null){
            artist = artistService.getArtistById(Integer.parseInt(id));
        }

        model.addAttribute("addArtist", artistService.addArtist(artist));

        return "addArtist";
    }

  @RequestMapping("/addArtist")
  public String saveArtists(@ModelAttribute Artist artist,Model model){
      model.addAttribute("addArtist", this.artistService.addArtist(artist));

      return "/addArtist";
  }

    @RequestMapping(value = "/deleteArtist/{id}",method = RequestMethod.GET)
    private String deleteArtist(@PathVariable String id){
        artistService.deleteArtist(Integer.parseInt(id));
        return "redirect:/artists";
    }




}
