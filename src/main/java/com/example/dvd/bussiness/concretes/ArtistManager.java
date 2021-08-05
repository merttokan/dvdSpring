package com.example.dvd.bussiness.concretes;

import com.example.dvd.bussiness.abstracts.ArtistService;
import com.example.dvd.dataAccess.abstracts.ArtistDao;
import com.example.dvd.entities.concretes.Artist;
import org.springframework.data.domain.Sort;
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
        return this.artistDao.findAll(Sort.by(Sort.Direction.ASC,"artId"));
    }

    @Override
    public Artist addArtist(Artist artist) {
        return this.artistDao.save(artist);
    }

    @Override
    public Artist getArtistById(int id) {
        return this.artistDao.getArtistById(id);
    }

    @Override
    public void deleteArtist(int id) {
        this.artistDao.deleteById(id);

    }
}
