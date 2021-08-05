package com.example.dvd.dataAccess.abstracts;

import com.example.dvd.entities.concretes.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ArtistDao extends JpaRepository<Artist,Integer> {
    @Query("FROM Artist a WHERE a.artId =:id")
    Artist getArtistById(int id);

}
