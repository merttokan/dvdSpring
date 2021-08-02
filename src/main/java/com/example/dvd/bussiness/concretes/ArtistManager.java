package com.example.dvd.bussiness.concretes;

import com.example.dvd.bussiness.abstracts.ArtistService;
import com.example.dvd.dataAccess.abstracts.ArtistDao;
import com.example.dvd.entities.concretes.Artist;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistManager implements ArtistService {
    private ArtistDao artistDao;

    public ArtistManager(ArtistDao artistDao) {
        super();
        this.artistDao = artistDao;
    }

    @Override
    public List<Artist> listAllArtists() {
        return this.artistDao.findAll();
    }

    @Override
    public Artist addArtist(Artist artist) {
        return this.artistDao.save(artist);
    }
}
