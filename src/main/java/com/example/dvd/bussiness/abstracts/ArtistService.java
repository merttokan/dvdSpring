package com.example.dvd.bussiness.abstracts;

import com.example.dvd.entities.concretes.Artist;
import com.example.dvd.entities.concretes.Movie;

import java.util.List;

public interface ArtistService {
    List<Artist> listAllArtists();
    Artist addArtist(Artist artist);
    Artist getArtistById(int id);
    void deleteArtist(int id);
}
