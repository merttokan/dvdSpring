package com.example.dvd.dataAccess.abstracts;

import com.example.dvd.entities.concretes.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistDao extends JpaRepository<Artist,Integer> {
}
