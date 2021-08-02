package com.example.dvd.bussiness.abstracts;

import com.example.dvd.entities.concretes.Artist;

import java.util.List;

public interface ArtistService {
    List<Artist> listAllArtists();
    Artist addArtist(Artist artist);
}
